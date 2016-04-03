package client.pages.musicDiary;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Stuff
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public abstract class Diary4Shell extends State {

    protected void init(){
        super.init();
        Image background = new Image(new Texture("Diary/Diary4BG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);
    }

    @Override
    public void dispose() {

    }
}
