package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.events.executables.internalChanges.TestExecutable;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends1 state.
 */
public abstract class Friends1Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends -1.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);

        stage.addActor(background);



        Button addFriendButton = new Button(this);
        addFriendButton.setBounds(633 + 1, 1217, 117, 117);
        addFriendButton.setExecutable(new TestExecutable("add friend"));
        add(addFriendButton);

        Button recordButton = new Button(this);
        recordButton.setBounds(0, 117, 750, 117);
        recordButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS2));
        add(recordButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}