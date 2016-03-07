package client.Components;

import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Component implements Disposable, Drawable, Updatable
{

    protected double x, y;
    protected double width, height;


    /**
     * Default constructor for Component.
     */
    public Component(){
        init();
    }


    /**
     * This sets the dimension of the component.
     *
     * Note: The x coordinate and y coordinate should have the origin in bottom left
     *       and it should be positive right and up, similar to standard cartesian coordinates.
     *
     * @param x The x value of the dimension.
     * @param y The y value of the dimension.
     */
    public void setDimension(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * This is the primary initialize method.
     *
     * This method is called automatically in the constructor of Component.
     */
    public abstract void init();
}
