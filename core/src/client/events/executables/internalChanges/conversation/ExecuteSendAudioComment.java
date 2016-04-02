package client.events.executables.internalChanges.conversation;

import client.pages.other.Sec1;
import client.stateInterfaces.Executable;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public class ExecuteSendAudioComment implements Executable {
    private Sec1 sec1;

    public ExecuteSendAudioComment(Sec1 sec1){
        this.sec1 = sec1;
    }

    @Override
    public void execute() {

    }
}
