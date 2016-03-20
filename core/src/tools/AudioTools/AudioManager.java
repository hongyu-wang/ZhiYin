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

    public static int[] trackLength(){
        int[] t = {audioPlayer.getCurrentAudio().getTrackMinutes(),audioPlayer.getCurrentAudio().getTrackSeconds()};
        return t;
    }

    public static void changeMusic(MAudio song) throws NSErrorException {
        audioPlayer.setSong(song);
    }
}
