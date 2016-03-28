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
        Image background = new Image(new Texture("NowPlayingMarch27/NowPlayingBG@1.0.png"));
        background.setBounds(0, 0, GameLoop.WIDTH * StateManager.M, GameLoop.HEIGHT * StateManager.M);
        stage.addActor(background);

        Button rewindButton = new Button(this);
        rewindButton.setBounds(170 + 1, 246, 53, 46);
        rewindButton.setExecutable(new TestExecutable("rewind"));
        add(rewindButton);

        Button fastForwardButton = new Button(this);
        fastForwardButton.setBounds(535 + 1, 246, 53, 46);
        fastForwardButton.setExecutable(new TestExecutable("fast forward"));
        add(fastForwardButton);

        Button b1 = new Button(this);
        b1.setBounds(0 + 1, 0, 230, 117);
        b1.setExecutable(new TestExecutable("b1"));
        add(b1);

        Button b2 = new Button(this);
        b2.setBounds(230 + 1, 0, 290, 117);
        b2.setExecutable(new TestExecutable("b2"));
        add(b2);

        Button b3 = new Button(this);
        b3.setBounds(520 + 1, 0, 230, 117);
        b3.setExecutable(new TestExecutable("b3"));
        add(b3);

        Button upVoteButton = new Button(this);
        upVoteButton.setBounds(562 + 1, 1240, 144, 54);
        upVoteButton.setExecutable(new TestExecutable("up vote"));
        add(upVoteButton);

//        Dimensions of the picture are 655 x 655
//        Button picture = new Button(this);
//        picture.setBounds(50 + 1, 1160 - 655, 655, 655);
//        picture.setExecutable(new TestExecutable("picture"));
//        add(picture);
    }

    @Override
    public void dispose() {

    }

}
