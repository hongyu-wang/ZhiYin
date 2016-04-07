package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MSnapShot;
import tools.AudioTools.AudioPlayer;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecutePlayMSnapShot implements Executable {
    private long snapShot;
    private LocalDatabase localDatabase;

    public ExecutePlayMSnapShot(MSnapShot snapShot) {

        this.localDatabase = LocalDatabaseFactory.createLocalDatabase();
        this.snapShot = snapShot.getKey();
    }

    @Override
    public void execute() {
        MSnapShot snapShot = LocalDatabaseFactory.createLocalDatabase().getModel(this.snapShot);
        if (os == MAC) {
            MAudio song = localDatabase.getModel(snapShot.getSong());
            MAudio voice = localDatabase.getModel(snapShot.getMessage());
            AudioPlayer audioPlayer = AudioPlayer.getInstance();

            if (audioPlayer.getCurrentAudio()!= null && audioPlayer.getCurrentAudio().getKey() == song.getKey()) {

                if (audioPlayer.isPlaying())
                    audioPlayer.pause();
                else {
                    audioPlayer.prepareToPlay();
                    audioPlayer.play();
                }

            } else{

                audioPlayer.setSongSnapShot(voice,song,(double)snapShot.getStartTime());
                audioPlayer.prepareToPlay();
                audioPlayer.play();

                localDatabase.removeKeyFromServer(snapShot.getKey());
            }

        } else{
            System.out.println("Windows Play");
        }





    }

}

