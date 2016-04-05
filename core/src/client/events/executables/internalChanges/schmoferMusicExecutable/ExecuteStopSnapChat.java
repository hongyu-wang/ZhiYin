package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.events.executables.internalChanges.serverInteractions.ExecuteSendSnapChat;
import client.stateInterfaces.Executable;
import tools.AudioTools.AudioPlayer;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteStopSnapChat implements Executable{

    @Override
    public void execute() {
        double[] time = AudioPlayer.getInstance().stopSnapChatTime();
        ExecuteSendSnapChat.time = time;
    }
}
