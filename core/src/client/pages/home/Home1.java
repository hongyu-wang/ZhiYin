package client.pages.home;

import client.component.basicComponents.ScrollTable;
import client.events.executables.internalChanges.ExecuteChangeandSetMusic;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home1 extends Home1Shell {
    public void init() {
        super.init();

        final Texture tex = new Texture("Scrolling Test 2.png");

        Image img = new Image(tex);
        Image img3 = new Image(new Texture("PictureFiles\\tempButton1.png"));

        Image img4 = new Image(new Texture("PictureFiles\\tempButton2.png"));
        Image img5 = new Image(new Texture("PictureFiles\\tempButton3.png"));

        final ScrollTable table = new ScrollTable();


        final ImageButton button1 = new ImageButton(img3.getDrawable());
        final ImageButton button2 = new ImageButton(img4.getDrawable());
        final ImageButton button3 = new ImageButton(img5.getDrawable());

        button1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangeandSetMusic("Ben Rector - 30,000 Feet.mp3").execute();
            }
        });

        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangeandSetMusic("Sara Bareilles - Bottle It Up.mp3").execute();
            }
        });

        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangeandSetMusic("Avril Lavigne - Everybody Hurts.mp3").execute();
            }
        });
        table.addToPane(button1);
        table.addToPane(button2);
        table.addToPane(button3);
        table.addToPane(img);



        stage.addActor(table.getPane());
    }


    @Override
    public void dispose() {

    }



    @Override
    public void draw(){
        super.draw();

    }

    @Override
    public void reset() {

    }

}
