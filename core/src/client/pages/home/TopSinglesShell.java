package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-23.
 */
public abstract class TopSinglesShell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Home/TopSinglesBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH * StateManager.M, GameLoop.HEIGHT * StateManager.M);
        stage.addActor(background);

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteChangePage(Pages.HOME1));
        add(backButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

}
