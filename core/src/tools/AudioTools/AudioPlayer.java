package tools.AudioTools;

import org.robovm.apple.avfoundation.AVAudioPlayer;
import org.robovm.apple.avfoundation.AVAudioSession;
import org.robovm.apple.avfoundation.AVAudioSessionCategory;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;

/**
 * Created by Kevin on 3/10/2016.
 */

public class AudioPlayer {

    private boolean running = false;

    private AVAudioPlayer player1;
    private AVAudioPlayer player2;
    boolean snapShot = false;
    private static AVAudioSession session = AVAudioSession.getSharedInstance();

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
        currentSong = voice;
        player1.dispose();
        player2.dispose();
        snapShot = true;

        try {
            player2 = new AVAudioPlayer(new NSData(voice.getmData()));
            player1 = new AVAudioPlayer(new NSData(song.getmData()));
            player1.setCurrentTime(startTime);
        } catch (NSErrorException e) {
            e.printStackTrace();
        }

        player1.setCurrentTime(startTime);
    }

    public void setSong(MAudio audio){
        currentSong = audio;
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
            session.setCategory(AVAudioSessionCategory.PlayAndRecord);
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
        if(!running)
            return false;
        running = player1.isPlaying();

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
