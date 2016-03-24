package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends4 state.
 */
public abstract class Friends4Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends4BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button messageButton = new Button(this);
        messageButton.setBounds(26 + 1, 31, 560, 60);
        messageButton.setExecutable(new TestExecutable("message"));
        add(messageButton);

        Button sendButton = new Button(this);
        sendButton.setBounds(604 + 1, 31, 122, 60);
        sendButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS4));
        add(sendButton);
    }

    @Override
    public void dispose() {

    }


}
