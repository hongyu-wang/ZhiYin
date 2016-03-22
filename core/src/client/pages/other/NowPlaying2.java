package client.pages.other;

import client.component.basicComponents.CommentWindow;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import driver.GameLoop;

/**
 * Created by Hongyu Wang on 3/19/2016.
 */
public class NowPlaying2 extends NowPlaying2Shell {
    float count = 0;
    public void init(){
        super.init();
        addWindow();
    }


    public void addWindow(){
        CommentWindow window = new CommentWindow();
        stage.addActor(window.getWindow());
    }

    @Override
    public void dispose() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void update(float dt) {
        super.update(dt);

    }
}
