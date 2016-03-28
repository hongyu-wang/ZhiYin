package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public abstract class MyProfileShell extends State {
    protected void init(){
        super.init();

        Image background = new Image(new Texture("Other/MyProfileBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        setBottomBar();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
