package client.pages.musicDiary;

import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

import static client.singletons.StateManager.M;

/**
 * This is the third music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary3 extends Diary3Shell {
    private TextField titleField;
    private TextField bodyField;

    public void init() {
        super.init();
        addTitleField();
        addBodyField();

        Image i = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));
        i.setPosition(32 * StateManager.M, 240 * StateManager.M);
        stage.addActor(i);

        DragButton swipeToDiscardDragButton = new DragButton(this, 380);
        swipeToDiscardDragButton.setBounds(32, 240, 694, 236);
        swipeToDiscardDragButton.setDragExecutable(new ExecuteChangePage(Pages.DIARY2));
        swipeToDiscardDragButton.setReleaseExecutable(new ExecuteChangePage(Pages.DIARY2));
        add(swipeToDiscardDragButton);
    }

    @Override
    public void reset() {
        titleField.remove();
        addTitleField();
        bodyField.remove();
        addBodyField();
    }

    private void addTitleField(){
        titleField = new WorkingTextArea("Title...", SkinSingleton.getInstance());
        titleField.setPosition((0 + 1) * M, 1112 * M);
        titleField.setSize(750* M, 88 * M);

        stage.addActor(titleField);
    }

    private void addBodyField(){
        bodyField = new WorkingTextArea("Text...", SkinSingleton.getInstance());
        bodyField.setPosition((0 + 1) * M, 724 * M);
        bodyField.setSize(750* M, 384 * M);

        stage.addActor(bodyField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        titleField.getText();//TODO something
        bodyField.getText();//TODO something
    }

    @Override
    public void dispose() {

    }
}
