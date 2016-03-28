package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class NowPlayingShell extends State{

    protected void init(){
        super.init();

        Image background = new Image(new Texture("NowPlayingMarch27/NowPlayingBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH * StateManager.M, GameLoop.HEIGHT * StateManager.M);
        stage.addActor(background);

        //        Dimensions of the picture are 655 x 655
        Button picture = new Button(this);
        picture.setBounds(50 + 1, 1160 - 655, 655, 655);
        picture.setExecutable(new TestExecutable("picture"));
        add(picture);

        TestExecutable rewindEx = new TestExecutable("rewind");
        addImageButton("NowPlayingMarch27/Rewind@", rewindEx, 170, 246, 53, 46);

        TestExecutable forwardEx = new TestExecutable("forward");
        addImageButton("NowPlayingMarch27/Forward@", forwardEx, 535, 246, 53, 46);

        TestExecutable commentEx = new TestExecutable("comment");
        addImageButton("NowPlayingMarch27/Comment@", commentEx, 0, 0, 230, 117);

        TestExecutable secEx = new TestExecutable("1s");
        addImageButton("NowPlayingMarch27/1S@", secEx, 230, 0, 290, 117);

        TestExecutable shareEx = new TestExecutable("share");
        addImageButton("NowPlayingMarch27/Share@", shareEx, 520, 0, 230, 117);

        TestExecutable likeEx = new TestExecutable("like");
        addImageButton("NowPlayingMarch27/Like@", likeEx, 562, 1240, 144, 54);
    }


    @Override
    public void dispose() {

    }

}
