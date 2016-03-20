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
//TODO error handle properly zzzzzzz
public class AudioPlayer {

    private boolean running = false;

    AVAudioPlayer player1;
    AVAudioPlayer player2;
    boolean snapShot;
    AVAudioSession session = AVAudioSession.getSharedInstance();

    private MAudio currentSong;
    private static AudioPlayer singleInstance = new AudioPlayer();

    private AudioPlayer(){

    }

    public static AudioPlayer getInstance(){
        return singleInstance;
    }

    public void setSong(MSnapShot ss){

        player1.dispose();
        player2.dispose();
        snapShot = true;

        player2 = new AVAudioPlayer(ss.getMessage().getmData()); //need to use long to request MAUdio
        player1 = new AVAudioPlayer(ss.getSong().getSong().getmData()); //same here
        player1.setCurrentTime((double)ss.getStartTime());
    }

    public void setSong(MMusic m){

        player1.dispose();
        player2.dispose();
        snapShot = false;
        player1 = new AVAudioPlayer(m.getSong().getmData()); //same here
    }

    public void setSong(MAudio audio){

        player1.dispose();
        player2.dispose();
        snapShot = false;
        try {
            player1 = new AVAudioPlayer(audio.getmData());
        } catch (NSErrorException e) {
            e.printStackTrace();
        }
    }

    public void setSong (NSURL path){

        player1.dispose();
        player2.dispose();
        snapShot = false;
        try {
            player1 = new AVAudioPlayer(path);
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
}
