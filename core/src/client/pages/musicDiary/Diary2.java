package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendDiaryPost;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.serverInteractions.ExecuteServer;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import server.model.media.MAudio;

/**
 * This is the second music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class
Diary2 extends Diary2Shell{
    private TextField titleField;
    private TextField bodyField;

    private MAudio audio;

    public Diary2(){
        init();
    }

    protected void init() {

        super.init();

        addTitleField();
        addBodyField();

        Button postButton = new Button(this);
        postButton.setBounds(750 - 117, 1217, 117, 117);
        ExecuteServer e = new ExecuteSendDiaryPost(this);
        postButton.setExecutable(e);
        add(postButton);


        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));

        DragButton dragButton = new DragButton(this, 360, image, getStage());
        dragButton.setInitialBounds(26, 130, 698, 236);

        //TODO setup dragbutton.


        // TODO make a new Diary4 using title, body, audio
        //em2.addExecutable(new ExecuteToTempState(new Diary4()));




        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(0, 0, 268, 264);
        holdToRecordButton.setExecutable(new ExecuteAddDragButton(dragButton));

        add(holdToRecordButton);

//        String title = getTitle();
//        String body = getBody();
//        Diary4 d = new Diary4(title, body, null);
//        Executable e = new ExecuteToTempState(d);
//        postButton.setExecutable(e);
//        add(postButton);
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
        bodyField.setPosition((0 + 1) * M, 553 * M);
        bodyField.setSize(750* M, 555 * M);

        stage.addActor(bodyField);
    }

    public String getTitle(){
        return titleField.getText();
    }

    public String getBody(){
        return bodyField.getText();
    }

    public MAudio getMAudio(){
        return this.audio;
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
