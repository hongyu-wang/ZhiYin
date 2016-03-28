package client.events.executables.internalChanges.dragButtonExecutables;

import client.component.basicComponents.DragButton;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/21/2016.
 */
public class ExecuteBeginTime implements Executable {
    @Override
    public void execute() {
        DragButton.setBegin(System.currentTimeMillis());
    }
}
