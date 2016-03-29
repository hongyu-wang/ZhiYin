package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.events.executables.internalChanges.TestExecutable;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.stateInterfaces.Executable;

/**
 * Created by Paul on 2016-03-28.
 */
public class ExecuteAddPlayMessage implements Executable {
    Friends2 friends2;

    public ExecuteAddPlayMessage(Friends2 friends2){
        this.friends2 = friends2;
    }

    @Override
    public void execute() {
        MessageBox soundbox = new MessageBox(new TestExecutable("Fuck"), 1);
        friends2.addMessage(soundbox);

    }
}
