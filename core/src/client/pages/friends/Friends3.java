package client.pages.friends;


import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.ExecuteReset;
import client.events.executables.internalChanges.ExecuteToTempState;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import driver.GameLoop;

public class Friends3 extends State {
    private Friends2 previousState;
    private Image image;
    public Friends3(ScrollPane pane, Friends2 past){
        init();


        addDragButton();
    }

    private void addDragButton(){
        stage.addActor(image = new Image(new Texture("Friends//SwipeToDiscardButton.png")));
        DragButton swipeButton = new DragButton(this, 300);
        swipeButton.setBounds(32, 234, 750, 283);
        ExecutableMultiplexer em = new ExecutableMultiplexer();
        em.addExecutable(new ExecuteToTempState(previousState));
        em.addExecutable(new ExecuteReset(this));

        ExecutableMultiplexer em2 = new ExecutableMultiplexer();
        em2.addExecutable(new ExecuteToTempState(previousState));
        em2.addExecutable(new ExecuteReset(this));

        swipeButton.setDragExecutable(em);
        swipeButton.setDragExecutable(em2);
    }


    public void init(){
        super.init();

//        DragButton SwipeToDiscardDragButton = new DragButton(this, 300);
//        SwipeToDiscardDragButton.setBounds(32, 234, 750, 283);
//        SwipeToDiscardDragButton.setDragExecutable(new ExecuteChangePage(Pages.FRIENDS1));
//        SwipeToDiscardDragButton.setReleaseExecutable(new ExecuteChangePage(Pages.FRIENDS3));
//        add(SwipeToDiscardDragButton);



    }

    @Override
    public void reset() {
        image.remove();


    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {
        super.update(dt);
    }

}
