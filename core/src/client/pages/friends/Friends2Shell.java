package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends2 state.
 */
public abstract class Friends2Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends - 2.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        add(background);



        Button discardButton = new Button(this);
        discardButton.setBounds(0 + 1, 117, 750, 283);
        discardButton.setExecutable(new TestExecutable("discard"));
        add(discardButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}