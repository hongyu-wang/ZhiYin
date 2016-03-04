package client.Components;

import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public abstract class Component implements Disposable, Drawable, Updatable
{
    protected SpriteBatch batch;
    protected double x, y;
    protected double width, height;

    public double getX() {
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
