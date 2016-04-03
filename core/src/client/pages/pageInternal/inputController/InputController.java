package client.pages.pageInternal.inputController;

import client.component.basicComponents.DragButton;
import client.internalExceptions.NoExecutableException;
import client.stateInterfaces.Performable;
import client.stateInterfaces.Pressable;
import tools.utilities.Utils;

import java.util.List;

/**
 *
 * This is the input controller class.
 * This is here in order to encapsulate input information away from the current
 * state class.
 * Created by Hongyu Wang on 3/13/2016.
 */
public class InputController {

    private List<Performable> pressables;

    public InputController(){
        init();
    }


    private void init(){
        pressables = Utils.newList();
    }


    public void add(Performable p){
        pressables.add(p);
    }
    public void remove(Performable p){
        pressables.remove(p);
    }


    /**
     * This is the method that will get called
     * by InputListener whenever the screen is pressed.
     */
    public void checkPressed(){
        for (Performable comp : pressables){
            if (comp instanceof Pressable)
                if (((Pressable)comp).isPressed()){
                    ((Pressable)comp).press();
                }
        }

    }

    public void checkDragged() {
        for (int i = 0; i < pressables.size(); i ++){
            if (pressables.get(i) instanceof DragButton){
                ((DragButton)pressables.get(i)).drag();

            }
        }
    }

    public void checkRelease() {
        for (Performable comp : pressables){
            if (comp instanceof DragButton){
                ((DragButton)comp).release();
            }
        }
    }
}
