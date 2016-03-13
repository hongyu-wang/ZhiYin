package client.inputController;

import client.stateInterfaces.Pressable;
import tools.utilities.Utils;

import java.util.List;

/**
 *
 * This is the input controller class.
 * This is here in order to encapsulate input information away from the current
 * state class.
 *
 * Created by Hongyu Wang on 3/13/2016.
 */
public class InputController {

    private boolean released;
    private List<Pressable> pressables;
    private Pressable currentButton;

    public InputController(){
        init();
    }


    private void init(){
        released = true;
        pressables = Utils.<Pressable>newList();
        currentButton = null;
    }


    public void add(Pressable p){
        pressables.add(p);
    }

    /**
     * This is the method that will get called
     * by InputListener whenever the screen is pressed.
     */
    public void checkPressed(){
        for (Pressable comp : pressables){
            if (comp.isPressed()){
                if (currentButton == null) {
                    released = false;
                    currentButton = comp;
                }

                else {
                    comp.press();
                    currentButton = null;
                    released = true;
                }
            }
        }

        if (currentButton != null && released)
            currentButton = null;
    }
}
