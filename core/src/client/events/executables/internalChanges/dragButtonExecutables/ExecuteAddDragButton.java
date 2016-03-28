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
    private int x, y, width, height;

    public ExecuteAddDragButton(DragButton button, int x, int y, int width, int height){
        this.button = button;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void execute() {
        button.setBounds(x*M, y*M, width*M, height*M);
    }
}
