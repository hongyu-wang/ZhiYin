package tools.AudioTools;

import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVAudioSession;
import org.robovm.apple.avfoundation.AVAudioSessionCategory;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;
import org.robovm.apple.audiotoolbox.AudioQueue;
import org.robovm.apple.audiotoolbox.AudioQueueBuffer;
import org.robovm.apple.audiotoolbox.AudioQueueParam;
import org.robovm.apple.coreaudio.AudioFormat;
import org.robovm.apple.coreaudio.AudioFormatFlags;
import org.robovm.apple.coreaudio.AudioStreamBasicDescription;
import org.robovm.apple.corefoundation.OSStatusException;
import org.robovm.rt.bro.Bro;
import org.robovm.rt.bro.Struct;
import org.robovm.rt.bro.annotation.Callback;
import org.robovm.rt.bro.annotation.Pointer;
import org.robovm.rt.bro.ptr.BytePtr;
import org.robovm.rt.bro.ptr.FunctionPtr;
import org.robovm.rt.bro.ptr.VoidPtr;
import server.model.media.MMusic;
import server.model.media.MSnapShot;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * Created by Kevin on 3/10/2016.
 */
public class AudioPlayer {

//    private int kNumberBuffers = 3;
//    private int mStateID = -1;
//    private boolean mRunning = false;
//
//    protected double mSampleRate;
//    protected AudioFormat mFormatID;
//    protected long mFormatFlags;
//    protected int mBytesPerPacket;
//    protected int mFramesPerPacket;
//    protected int mBytesPerFrame;
//    protected int mChannelsPerFrame;
//    protected int mBitsPerChannel;
//
//    private AudioQueue mQueue = null;
//
//    private MAudio track;
//    private Vector<byte[]> mData;
//
//    public AudioPlayer(){
//        mSampleRate = 44100;
//        mFormatID = AudioFormat.LinearPCM;
//        mFormatFlags = AudioFormatFlags.AudioFormatFlagIsPacked.value() | AudioFormatFlags.AudioFormatFlagIsSignedInteger.value();
//        mBytesPerPacket = 2;
//        mFramesPerPacket = 1;
//        mBytesPerFrame = 2;
//        mChannelsPerFrame = 1;
//        mBitsPerChannel = 16;
//    }
//
//    public AudioPlayer(MAudio track){
//        this();
//        this.track = track;
//        this.mData = track.getmData();
//    }
//
//    public static int getMinBufferSize(int sampleRate, int channelConfigurationMono, int encodingPcm16bit)
//    {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    public int deriveBufferSize(AudioStreamBasicDescription ASBDescription, int maxPacketSize, double seconds)
//    {
//        int maxBufferSize = 0x50000;
//        int minBufferSize = 0x4000;
//
//        double numPacketsForTime = ASBDescription.getSampleRate() / ASBDescription.getFramesPerPacket() * seconds;
//        int outBufferSize = (int)(numPacketsForTime * maxPacketSize);
//        if (outBufferSize > maxBufferSize) return maxBufferSize;
//        if (outBufferSize < minBufferSize) return minBufferSize;
//        return outBufferSize;
//    }
//
//    /*<bind>*/static { Bro.bind(MAudio.class); }/*</bind>*/
//    /*<constants>*//*</constants>*/
//    /*<constructors>*//*</constructors>*/
//    /*<properties>*//*</properties>*/
//    /*<members>*//*</members>*/
//    @Callback
//    public void callbackMethod(
//            AudioQueue inAQ,
//            AudioQueueBuffer inBuffer
//    )  throws OSStatusException
//    {
//        System.out.println("In Callback");
//        //AQPlayerState.AQPlayerStatePtr ptr = new AQPlayerState.AQPlayerStatePtr();
//        //ptr.set(refcon);
//        //AQPlayerState aqps = ptr.get();
//        //MAudio me = aqps.getTrack();
//        nextChunk(inAQ, inBuffer);
//    }
//
//    private void nextChunk(AudioQueue inAQ, AudioQueueBuffer inBuffer) throws OSStatusException
//    {
//        byte[] ba = null;
//        long when = System.currentTimeMillis() + 30000;
//        while (mRunning && System.currentTimeMillis() < when)
//        {
//            if (mData.size() > 0)
//            {
//                ba = mData.remove(0);
//                break;
//            }
//            try { Thread.yield(); } catch (Exception x) { x.printStackTrace(); }
//        }
//        if (ba == null) ba = new byte[0];
//        System.out.println("PLAYING BYTES: "+ba.length);
//
//        if (ba.length>0)
//        {
//            //
//            //BytePtr bp = vp.as(BytePtr.class); //Struct.allocate(BytePtr.class, ba.length);
//            BytePtr bp = new BytePtr();
//            bp.set(ba);
////          inBuffer.setMAudioData(vp);
//            inBuffer.setAudioData(inBuffer.getDataPointer(),ba.length);
//        }
//        mQueue.enqueueBuffer(inBuffer, inBuffer.getPacketDescriptions());
//    }
//
//    public void play ()
//    {
//       //final MAudio me = this;
//        final AudioPlayer me = this;
//
//        Runnable r = new Runnable()
//        {
//            public void run ()
//            {
//                AudioStreamBasicDescription asbd = new AudioStreamBasicDescription(mSampleRate, mFormatID, new AudioFormatFlags(mFormatFlags), mBytesPerPacket, mFramesPerPacket, mBytesPerFrame, mChannelsPerFrame, mBitsPerChannel);
//                AudioQueue.AudioQueuePtr mQueuePtr = new AudioQueue.AudioQueuePtr();
//                Method callbackMethod = null;
//                Method[] methods = me.getClass().getMethods();
//                int i = methods.length;
//                while (i-->0) if (methods[i].getName().equals("callbackMethod"))
//                {
//                    callbackMethod = methods[i];
//                    break;
//                }
//
//                FunctionPtr fp = new FunctionPtr(callbackMethod );
//
//                AQPlayerState aqData = new AQPlayerState(me);
//                mStateID = aqData.mID();
//                VoidPtr vp = aqData.as(VoidPtr.class);
////              AudioErrorCode aqe = AudioQueue.newOutput(asbd, fp, vp, CFRunLoop.getCurrent(), new CFString(CFRunLoopMode.Common.value()), 0, mQueuePtr);
////                AudioErrorCode aqe = AudioQueue.createOutput(asbd, fp, vp, null, null, 0, mQueuePtr);
////                System.out.println(aqe.name());
//                mQueue = mQueuePtr.get();
//
//                int bufferByteSize = deriveBufferSize(asbd, 2, 0.5);
//                System.out.println("BUFFER SIZE: "+bufferByteSize);
//
//                System.out.println("Volume PARAM:"+(int) AudioQueueParam.Volume.value());
//                try {
//                    mQueue.setParameter(AudioQueueParam.Volume, 1.0f);
//                } catch (OSStatusException e) {
//                    e.printStackTrace();
//                }
//
//                mRunning = true;
//
//                AudioQueueBuffer.AudioQueueBufferPtr mBuffers = Struct.allocate(AudioQueueBuffer.AudioQueueBufferPtr.class, kNumberBuffers);
//                AudioQueueBuffer.AudioQueueBufferPtr[] buffers = mBuffers.toArray(kNumberBuffers);
//
//                for (i = 0; i < kNumberBuffers; ++i)
//                {
//
//                    try {
//                        mQueue.allocateBuffer(bufferByteSize);
//                        nextChunk(mQueue, buffers[i].get());
//                    } catch (OSStatusException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                System.out.println("STARTING QUEUE");
//                try {
//                    mQueue.start(null);
//                } catch (OSStatusException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("QUEUE STARTED");
///*
//                System.out.println("RUNNING LOOP");
//                do
//                {
//                    System.out.print(".");
//                    CFRunLoop.runInMode(CFRunLoopMode.Default, 0.25, false);
//                    System.out.print("#");
//                }
//                while (mRunning);
//                System.out.println("!!!");
//                CFRunLoop.runInMode(CFRunLoopMode.Default, 1, false);
//                System.out.println("DONE RUNNING LOOP");
//                mQueue.stop(true);
//                AQPlayerState.drop(mStateID);
//                System.out.println("QUEUE STOPPED");
//*/
//            }
//        };
//
//        new Thread(r).start();
//    }
//
//    public void stop() throws OSStatusException {
//        System.out.println("STOPPING AUDIO PLAYER");
//        mRunning = false;
//        mQueue.stop(true);
//        AQPlayerState.drop(mStateID);
//    }

    AVAudioPlayer player1;
    AVAudioPlayer player2;
    boolean snapShot;
    AVAudioSession session = AVAudioSession.getSharedInstance();

    public void AudioPlayer(MSnapShot ss) throws NSErrorException{
        snapShot = true;

        player1 = new AVAudioPlayer(ss.getMessage().getmData());
        player2 = new AVAudioPlayer(ss.getSong().getSong().getmData());
        player2.setCurrentTime((double)ss.getStartTime());
    }

    public void AudioPlayer(MMusic m) throws NSErrorException{
        snapShot = false;
        player1 = new AVAudioPlayer(m.getSong().getmData());
    }

    public void AudioPlayer(MAudio audio) throws NSErrorException{
        snapShot = false;
        player1 = new AVAudioPlayer(audio.getmData());
    }

    public void prepareToPlay() throws NSErrorException {
        session.setActive(true);
        player1.prepareToPlay();
        player1.setDelegate(player1.getDelegate());
        if(snapShot) {
            player2.prepareToPlay();
            player2.setDelegate(player2.getDelegate());
        }
    }

    public void play() throws NSErrorException{
        session.setCategory(AVAudioSessionCategory.Playback);

        player1.play();
        if(snapShot)
            player2.play();

    }

    public void playAtTime(int time) throws NSErrorException{
        player1.setCurrentTime((double)time);
         if(snapShot)
            player2.setCurrentTime(player2.getCurrentTime() + (double)time);

        play();
    }

    public void pause() throws NSErrorException{

        player1.pause();
        if(snapShot)
            player2.pause();

    }

    public void stop() throws NSErrorException{
        session.setActive(false);
        player1.stop();
        if(snapShot)
            player2.stop();
    }
}
