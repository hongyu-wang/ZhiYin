package tools.AudioTools;

import java.io.*;
import java.lang.reflect.Method;

import org.robovm.apple.avfoundation.AVAudioRecorder;
import org.robovm.apple.avfoundation.AVAudioSession;
import org.robovm.apple.avfoundation.AVAudioSessionCategory;
import org.robovm.apple.avfoundation.AVAudioSettings;
import org.robovm.apple.corefoundation.OSStatusException;
import org.robovm.apple.foundation.*;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.block.BooleanBlock;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock2;
import org.robovm.objc.block.VoidBooleanBlock;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Pointer;
import org.robovm.apple.audiotoolbox.*;
import org.robovm.apple.audiotoolbox.AudioQueueBuffer.AudioQueueBufferPtr;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coreaudio.AudioTimeStamp.*;
import org.robovm.apple.coreaudio.AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr;
import org.robovm.apple.audiotoolbox.AudioQueue.*;
import org.robovm.apple.corefoundation.CFRunLoopMode;
import org.robovm.apple.coreaudio.AudioErrorCode;
import org.robovm.rt.VM;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.ptr.*;
import server.model.media.MAudio;
import server.model.media.MMusic;
import tools.serverTools.databases.LocalDatabaseFactory;

public class AudioRecorder {

    private static AudioRecorder singleInstance = new AudioRecorder();

    private boolean running = false;

    private long count = 0L;

    private String fp;

    private NSObject[] objects = {
        NSNumber.valueOf(44100.f),
        NSNumber.valueOf((int) AudioFormat.LinearPCM.value()),
        NSNumber.valueOf(2),
        NSNumber.valueOf(16),
        NSNumber.valueOf(false),
        NSNumber.valueOf(false)
    };

    private NSString[] keys ={
        AVAudioSettings.Keys.SampleRate(),
        AVAudioSettings.Keys.FormatID(),
        AVAudioSettings.Keys.NumberOfChannels(),
        AVAudioSettings.Keys.BitDepthKey(),
        AVAudioSettings.Keys.IsBigEndianKey(),
        AVAudioSettings.Keys.IsFloatKey(),

    };

    private AVAudioSettings settings;

    private void makeSettings(){
        for(int i=0;i<keys.length;i++)
            settings.set(keys[i],objects[i]);
    }

    NSURL filePath;
    private static NSFileManager fm;

    AVAudioSession session;
    AVAudioRecorder avar;

    public static AudioRecorder getInstance(){

        return singleInstance;
    }

    private AudioRecorder(){

        fm = new NSFileManager();
        settings = new AVAudioSettings();
        NSArray nsa = fm.getURLsForDirectory(NSSearchPathDirectory.DocumentDirectory, NSSearchPathDomainMask.UserDomainMask);
        filePath = (NSURL)nsa.first();
        session = AVAudioSession.getSharedInstance();
        makeSettings();
        fp = filePath.getPath()+ "/" + "song";
        try {
            avar = new AVAudioRecorder(new NSURL(fp), settings);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }



    }

    public void prepareToRecord(){

        try {

            //avar.dispose();
            session.setActive(true);
            String file =  fp+count;
            filePath = new NSURL(file);
            count++;
            avar = new AVAudioRecorder(filePath, settings);
            avar.setDelegate(avar.getDelegate());
            avar.setMeteringEnabled(true);
            session.setCategory(AVAudioSessionCategory.PlayAndRecord);


            avar.prepareToRecord();

        }catch(NSErrorException e){
            e.printStackTrace();
        }

    }

    public void startRecording() {

        running = true;
        //session.requestRecordPermission(b -> {

        //});


        avar.record();
    }

    public MAudio stopRecording(){
        running = false;

        avar.stop();


        NSData mData = new NSData(fm.getContentsAtPath(filePath.getPath()));

        MAudio audio = AudioCreator.createMAudio(mData);
        audio.setKey(LocalDatabaseFactory.createLocalDatabase().generateKey());

        AudioPlayer.getInstance().stop();

        try {
            session.setActive(false);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        return audio;
    }

    public boolean isRecording(){
        return avar.isRecording();
    }

    public void recordForOneSecond(){
        avar.record(1);
    }

    public MAudio getCurrentMData(){
        avar.stop();

        return AudioCreator.createMAudio(fm.getContentsAtPath(filePath.getPath()));
    }

}