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
        boolean press = false;
        for (Pressable comp : pressables){
            if (comp.isPressed()){
                press = true;
                if (currentButton == null) {
                    released = false;
                    currentButton = comp;
                    currentButton.setAnimation();
                } else {
                    if (comp == currentButton) {
                        currentButton.press();
                        currentButton.setAnimation();
                        currentButton = null;
                    }

                    released = true;
                }
            }
        }

        if (!press) released = true;

        if (currentButton != null && released) {
            currentButton.setAnimation();
            currentButton = null;
        }
    }
}
