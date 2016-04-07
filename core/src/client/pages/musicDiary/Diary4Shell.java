package client.pages.musicDiary;

import client.pages.State;
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
        Image background = new Image(tx = new Texture("Diary/Diary4BG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);
    }


}
