package tools.AudioTools;

import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;
import tools.AudioTools.*;

/**
 * Created by Kevin on 3/20/2016.
 */
public class AudioManager {

    private static AudioPlayer audioPlayer = AudioPlayer.getInstance();

    private AudioManager(){

    }

    public static double getTime(){
        return audioPlayer.getCurrentTime();
    }

    public static void playMusic(){
        audioPlayer.play();
    }

    public static void pauseMusic(){
        audioPlayer.pause();
    }

    public static void stopMusic(){
        audioPlayer.stop();
    }

    public static double trackLength(){
        return audioPlayer.getCurrentAudio().getTrackLength();
    }

    public static void changeMusic(MAudio song) {
        audioPlayer.setSong(song);
    }

    public static void setTime(double time){
        audioPlayer.setTime(time);
    }

    public static boolean isPlaying(){ return audioPlayer.isPlaying(); }
}
