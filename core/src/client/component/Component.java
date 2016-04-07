package client.component;

import client.singletons.MainBatch;
import client.stateInterfaces.Updatable;
import client.tools.Constants;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;


public abstract class Component extends Actor implements Updatable, Constants
{


    /**
     * This is the primary sprite_batch that all components will draw to
     */
    protected SpriteBatch spriteBatch = MainBatch.getInstance();


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
        setX(x * M);
        setY(y * M);
    }

    /**
     * This sets the dimensions of the component.
     * @param width This is the integer width of the component
     * @param height This is the integer height of the component.
     */
    public void setDimensions(int width, int height){
        setWidth(width*M);
        setHeight(height*M);
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

    @Override
    public void setBounds(float x, float y, float width, float height) {
        super.setBounds(x*M, y*M, width*M, height*M);

    }



}
