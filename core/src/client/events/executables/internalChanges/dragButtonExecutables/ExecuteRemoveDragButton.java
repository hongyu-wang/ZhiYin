package client.events.executables.internalChanges.dragButtonExecutables;

import client.component.basicComponents.DragButton;
import client.pages.friends.Friends2;
import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteRemoveDragButton implements Executable{
    private DragButton button;
    public ExecuteRemoveDragButton(DragButton button){
        this.button = button;
    }

    @Override
    public void execute() {
        button.setBounds(0, 12341234, 1234, 1234);
    }
}
