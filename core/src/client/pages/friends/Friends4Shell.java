package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * The shell for the Friends4 state.
 */
public abstract class Friends4Shell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Friends/Friends4BG.png"));
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);
        disposables.add(tx);

        Button messagesButton = new Button(this);
        messagesButton.setBounds(0, 1217, 375, 117);
        messagesButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS1, TransitionType.LEFT_TO_RIGHT));
        add(messagesButton);


        setBottomBar();
    }


}
