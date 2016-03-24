package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public abstract class ArtistProfileShell extends State {

    public void init() {
        super.init();

        Image background = new Image(new Texture("Other/ArtistProfileBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);
    }

    @Override
    public void reset() {

    }


    @Override
    public void dispose() {

    }
}
