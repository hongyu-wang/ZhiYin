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

    private MAudio mAudio;
    private LocalDatabase localDatabase;

    public ExecutePlayMAudio(MAudio mAudio){
        localDatabase = LocalDatabaseFactory.createLocalDatabase();
        this.mAudio = localDatabase.getModel(mAudio.getKey());
        System.out.println("created");
    }


    @Override
    public void execute() {
        if (os == MAC) {
            AudioPlayer audioPlayer = AudioPlayer.getInstance();
            if (audioPlayer.getCurrentAudio() == mAudio) {
                if (audioPlayer.isPlaying())
                    audioPlayer.pause();
                else {
                    audioPlayer.prepareToPlay();
                    audioPlayer.play();
                }


            } else {
                audioPlayer.setSong(mAudio);
                audioPlayer.prepareToPlay();
                audioPlayer.play();
            }
        } else{
            System.out.println("Windows Play");
        }





    }
}
