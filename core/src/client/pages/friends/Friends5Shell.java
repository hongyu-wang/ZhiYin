package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class Friends5Shell extends State {
    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends5BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button messagesButton = new Button(this);
        messagesButton.setBounds(0, 1217, 375, 117);
        messagesButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS1));
        add(messagesButton);

        setBottomBar();

    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
