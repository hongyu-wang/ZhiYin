package client.pages;

import client.component.Component;
import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.internalExceptions.NoExecutableException;
import client.stateInterfaces.*;
import tools.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the superclass of all States.
 *
 * All pages should extend this.
 */
public abstract class State implements Updatable, Drawable, Disposable, ActionMonitor {

    /**
     * This is the primary constructor of state.
     * No parameters should ever get passed into this constructor.
     */
    public State(){
        init();
    }

    private boolean released = true;

    private Pressable currentButton;

    private List<Pressable> pressables;


    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    private List<Component> components;

    /**
     * This method will initialize all values as required within state
     */
    public void init(){
        components = Utils.<Component>newList();
        pressables = Utils.<Pressable>newList();
        currentButton = null;
    }

    /**
     * This method will add a component to the components.
     *
     * This will also add all Performables to the performable list.
     * @param c the component to be added
     */
    public void add(Component c){
        if (c instanceof Pressable)
            pressables.add((Pressable)c);
        components.add(c);
    }

    /**
     * This will return a deep copy of the stored component list
     * @return A deep copy of the components.
     */
    public List<Component> getComponents(){

        List<Component> deepCopy = Utils.<Component>newList();
        for (Component comp : components){
            deepCopy.add(comp);
        }

        return deepCopy;
    }




    /**
     * This method will draw everything.
     */
    public void draw(){
        for (Component comp : components){
            comp.draw();
        }
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

    @Override
    public void actionPerformed(ActionEvent e){
        try {
            e.getSource().getExecutable().execute();
        } catch (NoExecutableException ex){
            System.out.println(ex.getMessage());
        }
    }

}

