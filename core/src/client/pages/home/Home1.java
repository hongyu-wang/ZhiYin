package client.pages.home;

import client.component.basicComponents.Image;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.Scrollable;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import driver.GameLoop;

/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home1 extends State implements Scrollable {
    private OrthographicCamera cam;
    public void init() {
        super.init();
        cam = new OrthographicCamera();
        Image background = new Image("Home - 1.png");
        background.setBounds(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);
        add(background);
    }


    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void drawScrolled() {

    }

    @Override
    public Matrix4 getCamera() {
        return cam.combined;
    }
}
