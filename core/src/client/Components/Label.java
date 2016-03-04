package client.Components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Label extends Component
{
    protected String text;

    public Label(){

    }

    public Label(SpriteBatch batch, double x, double y, double width, double height, String text){
        init(batch, x, y, width, height, text);
    }

    public void init(SpriteBatch batch, double x, double y, double width, double height, String text){
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

}
