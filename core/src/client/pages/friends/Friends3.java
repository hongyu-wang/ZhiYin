package client.pages.friends;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

public class Friends3 extends Friends3Shell{

    private ScrollPane pane;

    public Friends3(Stage stage){
        this.stage = stage;
        init();
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

    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {
        stage.act();
    }

}
