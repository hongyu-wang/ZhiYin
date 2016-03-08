package tools.AudioTools;

/**
 * Created by Kevin on 3/6/2016.
 */

import java.io.*;

import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Pointer;
import org.robovm.apple.audiotoolbox.*;
import org.robovm.apple.audiotoolbox.AudioQueueBuffer.AudioQueueBufferPtr;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coreaudio.AudioTimeStamp.*;
import org.robovm.apple.coreaudio.AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr;

import org.robovm.rt.VM;


public class AudioRecorder {

    protected double mSampleRate;


    private int kNumberBuffers = 3;

    protected AudioQueue mQueue;

    private PipedInputStream mPIS;
    private PipedOutputStream mPOS;
    private int mStateID = -1;

    protected AudioStreamBasicDescription mDataFormat;
    protected AudioQueueBuffer mQueuePtr;
    protected AudioQueueBufferPtr mBuffers;
    protected Audio soundFile;

    protected int bufferByteSize;

    protected int mCurrentPacket;

    protected int mBytesPerPacket;
    protected int mBitsPerChannel;
    protected int mChannelsPerFrame;
    protected int mFramesPerPacket;
    protected int mBytesPerFrame;

    protected AudioFormat mFormatID;
    protected AudioFormatFlags mFormatFlags;

    private boolean mRunning = false;

    public AudioRecorder() throws IOException{
        mSampleRate = 44100.0;
        mFormatID = AudioFormat.LinearPCM;
        mFormatFlags = (AudioFormatFlags.AudioFormatFlagIsPacked | AudioFormatFlags.AudioFormatFlagIsSignedInteger);

        mFramesPerPacket = 1;
        mBytesPerFrame = 2;
        mBytesPerPacket = 2;
        mChannelsPerFrame =1;
        mBitsPerChannel = 16;

        mPOS = new PipedOutputStream();
        mPIS = new PipedInputStream(mPOS);

    }


    public int deriveBufferSize(AudioQueue aq, AudioStreamBasicDescription asbd, double seconds){
        int maxBufferSize = 0x50000;
        int maxPacketSize = asbd.getBytesPerPacket()/1000000;

        double numBytesForTime = asbd.getSampleRate()/1000000 * maxPacketSize * seconds;
        return (int)(numBytesForTime < maxBufferSize ? numBytesForTime : maxBufferSize);

    }

    public void release(){
        mRunning = false;
        mQueue.stop(true);

        try {
            mPOS.close();
            mPIS.close();
        }catch(Exception e){e.printStackTrace()};

    }

    @Callback
    public static void callback(@Pointer long refcon, AudioQueue AQ, AudioQueueBuffer buffer, AudioTimeStampPtr startTime, int numPackets, AudioStreamPacketDescriptionPtr packetDesc){

        try
        {
            AQRecorderState.AQRecorderStatePtr ptr = new AQRecorderState.AQRecorderStatePtr();
            ptr.set(refcon);
            AQRecorderState aqrs = ptr.get();
            byte[] ba = VM.newByteArray(buffer.getMAudioData().getHandle(), buffer.getMAudioDataByteSize());
            aqrs.getRecord().receive(ba);
        }
        catch (Exception x) { x.printStackTrace(); }

        AQ.enqueueBuffer(buffer, 0, null);

    }

    public void startRecording() throws Exception{

    }
}
