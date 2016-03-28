package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends4 state.
 */
public abstract class Friends4Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends/Friends4BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button messagesButton = new Button(this);
        messagesButton.setBounds(0, 1217, 375, 117);
        messagesButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS1));
        add(messagesButton);

//        DragButton SwipeToDiscardDragButton = new DragButton(this, 300);
//        SwipeToDiscardDragButton.setBounds(0 + 1, 117, 750, 283);
//        SwipeToDiscardDragButton.setDragExecutable(new ExecuteChangePage(Pages.FRIENDS1));
//        SwipeToDiscardDragButton.setReleaseExecutable(new ExecuteChangePage(Pages.FRIENDS3));
//        add(SwipeToDiscardDragButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }


}
