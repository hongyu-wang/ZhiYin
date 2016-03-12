package client.pages;

import client.component.Component;
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

    protected List<Performable> performables;


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
    }

    /**
     * This method will add a component to the components.
     *
     * This will also add all Performables to the performable list.
     * @param c the component to be added
     */
    public void add(Component c){
        if (c instanceof Performable)
            performables.add((Performable) c);

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
     * This will return a deep copy of the stored performable list
     * @return A deep copy of the components.
     */
    public List<Performable> getPerformables(){
        List<Performable> deepCopy = Utils.<Performable>newList();
        for (Performable comp : performables){
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


}
