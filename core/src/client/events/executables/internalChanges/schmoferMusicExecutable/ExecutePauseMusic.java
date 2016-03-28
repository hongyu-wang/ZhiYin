package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import server.model.media.MMusic;
import tools.AudioTools.AudioManager;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecutePauseMusic implements Executable{


    @Override
    public void execute() {
        AudioManager.stopMusic();
    }
}
