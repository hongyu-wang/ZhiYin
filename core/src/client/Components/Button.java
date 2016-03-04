package client.Components;

import client.stateInterfaces.Pressable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Button extends Component implements Pressable
{
    public Button(){

    }

    public Button(SpriteBatch batch, double x, double y, double width, double height){
        init(batch, x, y, width, height);
    }

    public void init(SpriteBatch batch, double x, double y, double width, double height){
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
