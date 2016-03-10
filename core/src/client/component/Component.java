package client.component;

import client.singletons.MainBatch;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static client.singletons.StateManager.M;


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
        this.x = (int) (x * M);
        this.y = (int) (y * M);
    }

    /**
     * This sets the dimensions of the component.
     * @param width This is the integer width of the component
     * @param height This is the integer height of the component.
     */
    public void setDimensions(int width, int height){
        this.width = (int) (width * M);
        this.height = (int) (height * M);
    }

    /**
     * Sets both the position and dimensions of the component.
     * @param x The component's x coordinate.
     * @param y The y component's y coordinate.
     * @param width The component's width.
     * @param height The component's height.
     */
    public void setBounds(int x, int y, int width, int height){
        setPosition(x, y);
        setDimensions(width, height);
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
