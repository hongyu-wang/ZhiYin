package client.pages.musicDiary;

import client.pages.State;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public abstract class SongSelectionShell extends State {

    protected void init(){
        super.init();
        Image background = new Image(tx = new Texture("Diary/SongSelectionBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);
    }


}
