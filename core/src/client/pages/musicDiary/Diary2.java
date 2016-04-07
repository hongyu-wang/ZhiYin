package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendDiaryPost;
import client.events.executables.internalChanges.serverInteractions.ExecuteServer;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

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

        //------------------------------------------------------------------------------------------------------
        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@1.0.png"));

        DragButton dragButton = new DragButton(this, 360, image, getStage());
        dragButton.setInitialBounds(20, 270, 710, 280);

        //TODO setup dragbutton.
        dragButton.setDragExecutable(new ExecutableMultiplexer(
                () -> System.out.println("Drag")
        ));

        dragButton.setReleaseExecutable(new ExecutableMultiplexer(

                () -> System.out.println("Release")
            /*
             *TODO make a new Diary4 using title, body, audio (audio may be null).
             *new ExecuteToTempState(new Diary4())
             */

        ));

        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(0, 0, 268, 264);
        holdToRecordButton.setExecutable(new ExecutableMultiplexer(
                new ExecuteAddDragButton(dragButton)
        ));
        add(holdToRecordButton);

        Button pictureButton = new Button(this);
        pictureButton.setBounds(268, 0, 221, 264);
        pictureButton.setExecutable(new TestExecutable("picture"));
        add(pictureButton);

        Button videoButton = new Button(this);
        videoButton.setBounds(489, 0, 261, 264);
        videoButton.setExecutable(new TestExecutable("video"));
        add(videoButton);

    }

    private void changeBodyField(float m){
        bodyField.setBounds(0, (1102-m)*M, 750* M, m * M);
    }


    @Override
    public void reset() {
        super.reset();
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
        changeBodyField(830);

        stage.addActor(bodyField);
    }

    public String getTitle(){
        return titleField.getText();
    }

    public String getBody(){
        return bodyField.getText();
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
