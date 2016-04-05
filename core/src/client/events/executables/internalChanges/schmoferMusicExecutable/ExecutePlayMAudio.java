package client.events.executables.internalChanges.schmoferMusicExecutable;

import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import tools.AudioTools.AudioPlayer;

/**
 *
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecutePlayMAudio implements Executable{

    private long mAudioKey;
    private LocalDatabase localDatabase;

    public ExecutePlayMAudio(MAudio mAudio){
        this.localDatabase = LocalDatabaseFactory.createLocalDatabase();
        this.mAudioKey = mAudio.getKey();
    }


    @Override
    public void execute() {
        if (os == MAC) {
            MAudio mAudio = localDatabase.getModel(mAudioKey);
            AudioPlayer audioPlayer = AudioPlayer.getInstance();

            if (audioPlayer.getCurrentAudio()!= null && audioPlayer.getCurrentAudio().getKey() == mAudio.getKey()) {

                if (audioPlayer.isPlaying())
                    audioPlayer.pause();
                else {
                    audioPlayer.prepareToPlay();
                    audioPlayer.play();
                }

            } else{

                audioPlayer.setSong(mAudio);
                audioPlayer.prepareToPlay();
                audioPlayer.play();
            }

        } else{
            System.out.println("Windows Play");
        }





    }
}
