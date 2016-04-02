package client.events.executables.internalChanges.dragButtonExecutables;

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
        button.show();
    }
}
