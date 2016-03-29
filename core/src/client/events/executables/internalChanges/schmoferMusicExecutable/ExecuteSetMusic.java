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
    private MAudio audioFile;
    private ModelStorage ms;
    /**
     * Constructor for all Schmofer based music executables
     *
     * @param m the relevant MMusic from the server.
     */
    public ExecuteSetMusic(MMusic m) {
        ms = ModelStorageFactory.createModelStorage();
        mMusic = m;
        //audioFile = ms.getModel(mMusic.getMusicKey());
        audioFile = AudioCreator.keyToMAudio.get(m.getMusicKey());
    }

    @Override
    public void execute() {

        if (audioFile == null){
            ms.getModel(mMusic.getMusicKey());
            System.out.println("KEVIN YOU'RE FUCKING STUPID FROM: EXECUTE SET MUSIC");
        }else{
            System.out.println("worked");
            AudioManager.changeMusic(audioFile);
        }


    }
}
