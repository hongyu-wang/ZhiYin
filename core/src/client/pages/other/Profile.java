package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * This is the profile page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Profile extends State {
    public void init() {
        super.init();
        Image background = new Image(new Texture("Profile.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);

        add(background);
    }

    @Override
    public void reset() {

    }


    @Override
    public void dispose() {

    }

}
