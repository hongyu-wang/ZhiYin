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
 * Created by blobbydude24 on 2016-03-23.
 */
public abstract class TopSinglesShell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Home/TopSinglesBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteChangePage(Pages.HOME, TransitionType.LEFT_TO_RIGHT));
        add(backButton);

        setBottomBar();
    }



}
