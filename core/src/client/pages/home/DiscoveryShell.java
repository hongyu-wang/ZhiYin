package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class DiscoveryShell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Home/DiscoveryBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        Button homeButton = new Button(this);
        homeButton.setBounds(0, 1217, 260, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME, TransitionType.LEFT_TO_RIGHT));
        add(homeButton);

        Button artistButton = new Button(this);
        artistButton.setBounds(260, 1217, 150, 117);
        artistButton.setExecutable(new ExecuteChangePage(Pages.ARTIST, TransitionType.LEFT_TO_RIGHT));
        add(artistButton);
    }


}
