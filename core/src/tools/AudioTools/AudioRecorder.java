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

public class AudioRecorder {

    private static AudioRecorder singleInstance = new AudioRecorder();

    private boolean running = false;

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
        AVAudioSettings.Keys.IsFloatKey()
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
        System.out.println("hello");
        return singleInstance;
    }

    private AudioRecorder(){
        fm = new NSFileManager();
        settings = new AVAudioSettings();
        NSArray nsa = fm.getURLsForDirectory(NSSearchPathDirectory.DocumentDirectory, NSSearchPathDomainMask.UserDomainMask);
        filePath = (NSURL)nsa.first();
        session = AVAudioSession.getSharedInstance();
        makeSettings();
        String fp = filePath.getPath()+ "/" + "song";
        filePath = new NSURL(fp);
    }

    public void prepareToRecord() throws NSErrorException{


        avar = new AVAudioRecorder(filePath, settings);
        avar.setDelegate(avar.getDelegate());
        avar.setMeteringEnabled(true);
        session.setCategory(AVAudioSessionCategory.Record);
        session.setActive(true);
        avar.prepareToRecord();


    }

    public void startRecording() throws NSErrorException {

        running = true;
        //session.requestRecordPermission(b -> {
            //TODO test.
        //});


        avar.record();
    }

    public MAudio stopRecording(){
        running = false;
        try {
            session.setActive(false);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        avar.stop();
        avar.release();
        NSData mData = new NSData(fm.getContentsAtPath(filePath.getPath()));

        //MAudio voice = new MAudio();
        //voice.setmData(mData);
        avar.dispose();
        return AudioCreator.createMAudio(mData);
    }

    public boolean isRecording(){
        return running;
    }

    public void recordForOneSecond(){
        avar.record(1);
    }

    public NSData getCurrentMData(){
        avar.stop();
        avar.release();
        return fm.getContentsAtPath(filePath.getPath());
    }

}