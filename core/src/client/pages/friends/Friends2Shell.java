package client.pages.friends;

import client.pages.State;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * The shell for the Friends2 state.
 */
public abstract class Friends2Shell extends State {
    protected void init(){
        super.init();


        Image background = new Image(tx = new Texture("Friends/Friends2BG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);
    }





}
