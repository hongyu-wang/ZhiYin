package tools.AudioTools;

import java.io.*;
import java.lang.reflect.Method;

import org.robovm.apple.avfoundation.AVAudioRecorder;
import org.robovm.apple.avfoundation.AVAudioSession;
import org.robovm.apple.avfoundation.AVAudioSettings;
import org.robovm.apple.corefoundation.OSStatusException;
import org.robovm.apple.foundation.*;
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


    private static NSObject[] objects = {
        NSNumber.valueOf(44100.f),
        NSNumber.valueOf((int)AudioFormat.LinearPCM.value()),
        NSNumber.valueOf(2),
        NSNumber.valueOf(16),
        NSNumber.valueOf(false),
        NSNumber.valueOf(false)
    };

    private static NSObject[] keys ={
        AVAudioSettings.Keys.SampleRate(),
        AVAudioSettings.Keys.FormatID(),
        AVAudioSettings.Keys.NumberOfChannels(),
        AVAudioSettings.Keys.BitDepthKey(),
        AVAudioSettings.Keys.IsBigEndianKey(),
        AVAudioSettings.Keys.IsFloatKey()
    };

    private static NSDictionary settings = new NSDictionary(new NSArray(keys),new NSArray(objects));

    NSURL filePath;
    private static NSFileManager fm = new NSFileManager();
    private static int recordCount = 0;
    AVAudioSession session;
    AVAudioRecorder avar;

    public AudioRecorder(MMusic rs){
        NSArray nsa = fm.getURLsForDirectory(NSSearchPathDirectory.DocumentDirectory, NSSearchPathDomainMask.UserDomainMask);
        filePath = (NSURL)nsa.first();
        session = AVAudioSession.getSharedInstance();

    }

    public void prepareToRecord() throws NSErrorException{
        String fp  = filePath.getAbsoluteString() + recordCount +".mp3";
        filePath = new NSURL(fp);
        fm.createFileAtPath(fp, new NSData(), null);
        //avar = new AVAudioRecorder(filePath, new AVAudioSettings(settings));
        recordCount++;
    }

    public void startRecording() throws NSErrorException {
        //session.requestRecordPermission(); // what the fuck is a void boolean block help
        session.setActive(true);
        avar.prepareToRecord();
        avar.record();
    }

    public MAudio stopRecording() throws NSErrorException{
        session.setActive(false);
        NSData mData = fm.getContentsAtPath(filePath.getAbsoluteString());

        MAudio voice = new MAudio();
        voice.setmData(mData);

        return voice;
    }





}