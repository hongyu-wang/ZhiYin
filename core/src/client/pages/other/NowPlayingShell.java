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

    public void init(){
        super.init();

        Image background = new Image(new Texture("Now Playing.jpg"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        add(background);

        Button backButton = new Button(this);
        backButton.setBounds(0 + 1, 1217, 117, 117);
        backButton.setExecutable(new TestExecutable("back"));
        add(backButton);

        Button pauseButton = new Button(this);
        pauseButton.setBounds(310 + 1, 198, 140, 140);
        pauseButton.setExecutable(new TestExecutable("pause"));
        add(pauseButton);

        Button rewindButton = new Button(this);
        rewindButton.setBounds(180 + 1, 235, 70, 70);
        rewindButton.setExecutable(new TestExecutable("rewind"));
        add(rewindButton);

        Button fastForwardButton = new Button(this);
        fastForwardButton.setBounds(540 + 1, 235, 70, 70);
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
    }

    @Override
    public void dispose() {

    }

}
