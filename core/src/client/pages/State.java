package client.pages;

import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Pauseable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Hongyu Wang on 3/1/2016.
 */
public abstract class State implements Pauseable, Updatable, Drawable, Disposable {
    /**
     * This is the sprite batch which all components will be used to draw.
     */
    protected SpriteBatch spriteBatch;



}
