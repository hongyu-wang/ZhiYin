package client.pages;

import client.components.Component;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Pauseable;
import client.stateInterfaces.Updatable;
import tools.ServiceList;

public abstract class State implements Pauseable, Updatable, Drawable, Disposable {


    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    protected ServiceList<Component> components;





    /**
     * This method will initialize all values
     */
    public void init(){
        components = new ServiceList<Component>();
    }



}
