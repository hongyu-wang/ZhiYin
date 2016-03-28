package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class HomeShell extends State{

    public void init(){
        super.init();

        Image background = new Image(new Texture("Home/HomeBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH * StateManager.M, GameLoop.HEIGHT * StateManager.M);
        stage.addActor(background);

        Button artistButton = new Button(this);
        artistButton.setBounds(250 + 1, 1217, 250, 117);
        artistButton.setExecutable(new ExecuteChangePage(Pages.ARTIST));
        add(artistButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(500 + 1, 1217, 250, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.DISCOVERY));
        add(discoveryButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }


}
