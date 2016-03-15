package client.pages.home;

import client.component.basicComponents.ScrollTable;
import client.pages.State;
import client.singletons.MainBatch;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import driver.GameLoop;

/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home1 extends Home1Shell {
    private OrthographicCamera cam;
    public void init() {
        super.init();
        Texture tex = new Texture("Scrolling Test 2.png");

        Image img = new Image(tex);
        Image img2 = new Image(tex);

        ScrollTable table = new ScrollTable();


        ImageButton button = new ImageButton(img.getDrawable());

        table.addToPane(img);
        table.addToPane(img2);
        table.addToPane(button);

        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println('a');
                table.addToPane(new Image(tex));
            }
        });


        stage.addActor(table.getPane());
    }


    @Override
    public void dispose() {

    }



    @Override
    public void draw(){
        super.draw();

    }

}
