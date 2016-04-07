package client.pages.home;

import client.pages.State;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public abstract class TaggedShell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Home/TaggedBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        setBottomBar();
    }
}
