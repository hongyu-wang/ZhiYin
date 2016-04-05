package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-04-05.
 */
public abstract class ShareShell extends State {
    protected void init(){
        super.init();

        Image background = new Image(new Texture("Other/MyProfileBG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);

        setBottomBar();

    }

    @Override
    public void dispose() {

    }

}
