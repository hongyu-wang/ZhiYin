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
    }


    @Override
    public void execute() {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();

        if (audioPlayer.getCurrentAudio() == mAudio){

            if (audioPlayer.isPlaying())
                audioPlayer.pause();
            else
                audioPlayer.play();


        } else{
            audioPlayer.setSong(mAudio);
        }





    }
}
