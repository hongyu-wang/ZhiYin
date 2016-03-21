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

        Image background = new Image(new Texture("Friends1BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button friendListButton = new Button(this);
        friendListButton.setBounds(375, 1217, 375, 117);
        friendListButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS5));
        add(friendListButton);

        Button createGroupButton = new Button(this);
        createGroupButton.setBounds(0, 117*2, 750, 117);
        createGroupButton.setExecutable(new TestExecutable("create group"));
        add(createGroupButton);

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