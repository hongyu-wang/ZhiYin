package client.pages.home;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public abstract class TaggedShell extends State {

    protected void init(){
        super.init();

        Image background = new Image(new Texture("Home/TaggedBG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);
    }
}
