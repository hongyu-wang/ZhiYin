package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import server.model.media.MMusic;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioManager;
import tools.AudioTools.AudioPlayer;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecuteSetMusic implements Executable {

    private MMusic mMusic;

    /**
     * Constructor for all Schmofer based music executables
     *
     * @param m the relevant MMusic from the server.
     */
    public ExecuteSetMusic(MMusic m) {
        mMusic = m;
    }

    @Override
    public void execute() {
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        MAudio audioFile = AudioCreator.keyToMAudio.get(mMusic.getMusicKey());

        if (audioFile == null){
            ms.requestModelFromServer(mMusic.getMusicKey());
            System.out.println("KEVIN YOU'RE FUCKING STUPID FROM: EXECUTE SET MUSIC");
        }else{
            System.out.println("worked");
            AudioManager.changeMusic(audioFile);
        }


    }
}
