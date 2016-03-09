package client.component;

import client.singletons.MainBatch;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Component implements Disposable, Drawable, Updatable
{
    /**
     * This four variables represent the dimension and position of the component.
     */
    protected int x, y, width, height;

    /**
     * This is the primary sprite_batch that all components will draw to
     */
    protected SpriteBatch sprite_batch = MainBatch.getInstance();


    /**
     * Default constructor for Component.
     */
    public Component(){
        init();
    }


    /**
     * Creates a component with given position and dimensions.
     *
     * @param x The component's x value.
     * @param y The component's y value.
     * @param width The component's width.
     * @param height The component's height.
     */
    public Component(int x, int y, int width, int height){
        setPosition(x, y);
        setDimension(width, height);
    }

    /**
     * This is the primary initialize method.
     *
     * This method is called automatically in the constructor of Component.
     */
    protected void init(){}


    /**
     * This sets the position of the component.
     *
     * Note: The x coordinate and y coordinate should be the top left point of the rectangle.
     *
     *
     * @param x The x value of the dimension.
     * @param y The y value of the dimension.
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * This sets the dimensions of the component.
     * @param width This is the integer width of the component
     * @param height This is the integer height of the component.
     */
    public void setDimension(int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * This gets the x coordinate of the component.
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * This gets the y coordinate of the component.
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * This gets the width of the component.
     * @return width of the component
     */
    public int getWidth() {
        return width;
    }

    /**
     * This gets the height of the component
     * @return height of the component
     */
    public int getHeight() {
        return height;
    }

}
