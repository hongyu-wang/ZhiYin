package client.pages.other;

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
public abstract class ProfileShell extends State {

    public void init() {
        super.init();

        Image background = new Image(new Texture("Profile.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        add(background);

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteChangePage(Pages.HOME1));
        add(backButton);
    }

    @Override
    public void reset() {

    }


    @Override
    public void dispose() {

    }
}
