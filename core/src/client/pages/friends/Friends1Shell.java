package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * The shell for the Friends1 state.
 */
public abstract class Friends1Shell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Friends/Friends1BG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        Button friendsButton = new Button(this);
        friendsButton.setBounds(375, 1217, 375, 117);
        friendsButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS4, TransitionType.RIGHT_TO_LEFT));
        add(friendsButton);

        setBottomBar();
    }




}