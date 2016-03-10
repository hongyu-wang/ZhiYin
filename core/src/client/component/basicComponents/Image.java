package client.component.basicComponents;

import client.component.Component;
import com.badlogic.gdx.graphics.Texture;

public class Image extends Component {
    protected Texture image;

    public Image(String path){
        image = new Texture(path);
    }


    @Override
    protected void init() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw() {
        sprite_batch.draw(image, this.x, this.y, this.width, this.height);
    }

    @Override
    public void update(float dt) {

    }
}