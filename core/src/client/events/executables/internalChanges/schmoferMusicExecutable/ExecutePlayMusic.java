package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import tools.AudioTools.AudioManager;


/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecutePlayMusic implements Executable{


    @Override
    public void execute() {
        if (AudioManager.isPlaying())
            AudioManager.stopMusic();
        else
            AudioManager.playMusic();
    }
}
