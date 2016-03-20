package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.*;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;


public abstract class NowPlaying2Shell extends State {
    public void init(){
        super.init();
        Image background = new Image(new Texture("Now Playing - 2.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button backButton = new Button(this);
        backButton.setBounds(0 + 1, 1217, 117, 117);
        ExecutableMultiplexer executables = new ExecutableMultiplexer();
        executables.addExecutable(new ExecuteChangePage(Pages.HOME1));
        executables.addExecutable(new ExecutePauseMusic());
        backButton.setExecutable(executables);
        add(backButton);

        Button rewindButton = new Button(this);
        rewindButton.setBounds(170 + 1, 246, 53, 46);
        rewindButton.setExecutable(new TestExecutable("rewind"));
        add(rewindButton);

        Button fastForwardButton = new Button(this);
        fastForwardButton.setBounds(535 + 1, 246, 53, 46);
        fastForwardButton.setExecutable(new TestExecutable("fast forward"));
        add(fastForwardButton);

        Button pauseButton = new Button(this);
        pauseButton.setBounds(288 + 1, 177, 180, 180);
        pauseButton.setExecutable(new ExecutePlayMusic());
        add(pauseButton);

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
}
