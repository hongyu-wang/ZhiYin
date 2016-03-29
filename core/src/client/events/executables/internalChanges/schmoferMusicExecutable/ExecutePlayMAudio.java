package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import tools.AudioTools.AudioManager;
import tools.AudioTools.AudioPlayer;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecutePlayMAudio implements Executable{

    private MAudio mAudio;

    public ExecutePlayMAudio(MAudio mAudio){

        this.mAudio = mAudio;
        System.out.println("created");
    }


    @Override
    public void execute() {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        System.out.println('b');
        if (audioPlayer.getCurrentAudio() == mAudio){
            System.out.println('a');
            if (audioPlayer.isPlaying())
                audioPlayer.pause();
            else {
                audioPlayer.prepareToPlay();
                audioPlayer.play();
            }


        } else{
            audioPlayer.setSong(mAudio);
            System.out.println("song set");
            audioPlayer.prepareToPlay();
            System.out.println("prepared");
            audioPlayer.play();
        }





    }
}
