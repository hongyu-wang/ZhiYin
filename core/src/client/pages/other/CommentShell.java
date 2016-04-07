package client.pages.other;

import client.pages.State;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public abstract class CommentShell extends State {

    public void init(){
        super.init();

        Image background = new Image(tx = new Texture("Other/CommentBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);
    }
}
