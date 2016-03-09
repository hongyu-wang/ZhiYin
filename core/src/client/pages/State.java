package client.pages;

import client.component.Component;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import tools.utilities.ServiceList;

public abstract class State implements Updatable, Drawable, Disposable {


    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    protected ServiceList<Component> components;

    /**
     * This method will initialize all values
     */
    public void init(){
        components = new ServiceList<>();
    }



}
