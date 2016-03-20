package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends3 state.
 */
public abstract class Friends3Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends - 3.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);



        Button discardButton = new Button(this);
        discardButton.setBounds(1, 0, 375, 117);
        discardButton.setExecutable(new TestExecutable("discard"));
        add(discardButton);

        Button sendButton = new Button(this);
        sendButton.setBounds(375 + 1, 0, 375, 117);
        sendButton.setExecutable(new TestExecutable("send"));
        add(sendButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }

}
