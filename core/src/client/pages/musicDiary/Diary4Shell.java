package client.pages.musicDiary;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Stuff
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public abstract class Diary4Shell extends State {

    public void init(){
        super.init();
        Image background = new Image(new Texture("Diary - 4.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        add(background);
    }

    @Override
    public void dispose() {

    }
}
