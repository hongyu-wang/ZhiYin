package client.events.executables.internalChanges;

import client.component.basicComponents.DragButton;
import client.stateInterfaces.Executable;

import static client.singletons.StateManager.M;

/**
 *
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteAddDragButton implements Executable{

    private DragButton button;
    public ExecuteAddDragButton(DragButton button){
        this.button = button;
    }

    @Override
    public void execute() {
        button.setBounds(32*M, 98*M, (750-64)*M, 236*M);
    }
}
