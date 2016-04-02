package client.events.executables.internalChanges.schmoferMusicExecutable;

import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MMusic;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioManager;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecuteSetMusic implements Executable {

    private MMusic mMusic;
    private MAudio audioFile;
    private LocalDatabase localDatabase;
    /**
     * Constructor for all Schmofer based music executables
     *
     * @param m the relevant MMusic from the server.
     */
    public ExecuteSetMusic(MMusic m) {
        localDatabase = LocalDatabaseFactory.createLocalDatabase();
        mMusic = m;
        //audioFile = localDatabase.getModel(mMusic.getMusicKey());
        audioFile = AudioCreator.keyToMAudio.get(m.getMusicKey());
    }

    @Override
    public void execute() {

        if (audioFile == null){
            localDatabase.getModel(mMusic.getMusicKey());
            System.out.println("KEVIN YOU'RE FUCKING STUPID FROM: EXECUTE SET MUSIC");
        }else{
            System.out.println("worked");
            AudioManager.changeMusic(audioFile);
        }


    }
}
