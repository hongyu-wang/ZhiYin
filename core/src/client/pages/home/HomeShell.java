package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 *
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class HomeShell extends State{

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Home/HomeBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        Button artistButton = new Button(this);
        artistButton.setBounds(260, 1217, 150, 117);
        artistButton.setExecutable(new ExecuteChangePage(Pages.ARTIST, TransitionType.RIGHT_TO_LEFT));
        add(artistButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(410, 1217, 340, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.DISCOVERY, TransitionType.RIGHT_TO_LEFT));
        add(discoveryButton);

        setBottomBar();
    }




}
