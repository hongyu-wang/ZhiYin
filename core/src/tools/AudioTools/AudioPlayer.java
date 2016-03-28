package tools.AudioTools;

import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVAudioSession;
import org.robovm.apple.avfoundation.AVAudioSessionCategory;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
import org.robovm.apple.foundation.NSURL;
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

    private boolean running = false;

    AVAudioPlayer player1;
    AVAudioPlayer player2;
    boolean snapShot;
    AVAudioSession session = AVAudioSession.getSharedInstance();

    private MAudio currentSong;
    private static AudioPlayer singleInstance = new AudioPlayer();

    private AudioPlayer(){
        player1 = new AVAudioPlayer();
        player2 = new AVAudioPlayer();
    }

    public static AudioPlayer getInstance(){
        return singleInstance;
    }


    public void setSongSnapShot(MAudio voice, MAudio song, double startTime){

        player1.dispose();
        player2.dispose();
        snapShot = true;

        try {
            player2 = new AVAudioPlayer(new NSData(song.getmData()));
            player1 = new AVAudioPlayer(new NSData(voice.getmData()));
        } catch (NSErrorException e) {
            e.printStackTrace();
        }

        player1.setCurrentTime(startTime);
    }

    public void setSong(MAudio audio){

            player1.dispose();
        if(snapShot)
            player2.dispose();
        snapShot = false;

        try {
            player1 = new AVAudioPlayer(new NSData(audio.getmData()));
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
    }

    public void prepareToPlay() {
        try {
            session.setActive(true);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        player1.prepareToPlay();
        player1.setDelegate(player1.getDelegate());
        if(snapShot) {
            player2.prepareToPlay();
            player2.setDelegate(player2.getDelegate());
        }
    }

    public void play(){
        running = true;
        try {
            session.setCategory(AVAudioSessionCategory.Playback);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }

        player1.play();
        if(snapShot)
            player2.play();

    }

    public void playAtTime(int time){
        player1.setCurrentTime((double)time);
         if(snapShot)
            player2.setCurrentTime(player2.getCurrentTime() + (double)time);

        play();
    }

    public void pause(){
        running = false;
        player1.stop();
        if(snapShot)
            player2.stop();

    }

    public void stop(){
        running = false;
        try {
            session.setActive(false);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
        player1.stop();
        if(snapShot)
            player2.stop();


    }

    public boolean isPlaying(){
        return running;
    }

    public MAudio getCurrentAudio(){
        return currentSong;
    }

    public double getCurrentTime(){
        return player1.getCurrentTime();
    }

    public void setTime(double time){
        player1.setCurrentTime(time);
    }
}
