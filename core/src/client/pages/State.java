package client.pages;

import client.component.Component;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the superclass of all States.
 *
 * All pages should extend this.
 */
public abstract class State implements Updatable, Drawable, Disposable, ActionMonitor {


    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    protected List<Component> components;

    /**
     * This method will initialize all values as required within state
     */
    public void init(){
        components = new ArrayList<Component>();
    }



}
