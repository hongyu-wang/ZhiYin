package client.pages;

import client.Components.Component;
import client.MainBatch;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Pauseable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tools.ServiceList;

public abstract class State implements Pauseable, Updatable, Drawable, Disposable {


    /**
     * This is the primary spriteBatch for all state classes.
     * This is gotten from the Singleton SpriteBatch instance within MainBatch.
     */
    protected SpriteBatch spriteBatch = MainBatch.getInstance();

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
