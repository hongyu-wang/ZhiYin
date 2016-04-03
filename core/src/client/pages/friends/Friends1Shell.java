package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
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

    protected void init(){
        super.init();

        Image background = new Image(new Texture("Friends/Friends1BG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);

        Button friendsButton = new Button(this);
        friendsButton.setBounds(375, 1217, 375, 117);
        friendsButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS4));
        add(friendsButton);


        setBottomBar();
    }

    @Override
    public void dispose() {

    }



}