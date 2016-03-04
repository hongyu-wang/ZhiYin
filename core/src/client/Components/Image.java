package client.Components;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Image extends Component
{
    protected Sprite image;

    public Image(){

    }

    public Image(SpriteBatch batch, double x, double y, double width, double height, Sprite image){
        init(batch, x, y, width, height, image);
    }

    public void init(SpriteBatch batch, double x, double y, double width, double height, Sprite image){
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

}
