package client.pages.friends;

import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * The shell for the Friends2 state.
 */
public abstract class Friends2Shell extends State {

    public void init(){
        super.init();

        Image background = new Image(new Texture("Friends2BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        DragButton SwipeToDiscardDragButton = new DragButton(this, 350);
        SwipeToDiscardDragButton.setBounds(0 + 1, 117, 750, 283);
        SwipeToDiscardDragButton.setDragExecutable(new ExecuteChangePage(Pages.FRIENDS1));
        SwipeToDiscardDragButton.setReleaseExecutable(new ExecuteChangePage(Pages.FRIENDS3));
        add(SwipeToDiscardDragButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}
