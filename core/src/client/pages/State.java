package client.pages;

import client.Components.Component;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Pauseable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tools.ServiceList;

public abstract class State implements Pauseable, Updatable, Drawable, Disposable {
    /**
     * This is the sprite batch which all components will be used to draw.
     */
    protected SpriteBatch spriteBatch;

    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    protected ServiceList<Component> components;





    /**
     * This method will initialize all values
     */
    protected void init(SpriteBatch sb){
        spriteBatch = sb;
        components = new ServiceList<Component>();
    }


}
