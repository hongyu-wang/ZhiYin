package client.pages.pageInternal.inputController;

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

    private List<Pressable> pressables;

    public InputController(){
        init();
    }


    private void init(){
        pressables = Utils.newList();
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
                comp.press();
            }
        }

    }
}
