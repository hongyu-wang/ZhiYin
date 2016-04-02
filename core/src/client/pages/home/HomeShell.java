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

    protected void init(){
        super.init();

        Image background = new Image(new Texture("Home/HomeBG.png"));
        background.setBounds(0, 0, WIDTH * StateManager.M, HEIGHT * StateManager.M);
        stage.addActor(background);

        Button artistButton = new Button(this);
        artistButton.setBounds(260, 1217, 150, 117);
        artistButton.setExecutable(new ExecuteChangePage(Pages.ARTIST));
        add(artistButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(410, 1217, 340, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.DISCOVERY));
        add(discoveryButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }


}
