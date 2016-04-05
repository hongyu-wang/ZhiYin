package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import tools.AudioTools.AudioPlayer;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteStartSnapChat implements Executable{
    public ExecuteStartSnapChat(){}

    @Override
    public void execute() {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();

        audioPlayer.startSnapChatTime();
    }
}
