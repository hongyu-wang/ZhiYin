package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

import static client.singletons.StateManager.M;

/**
 * This is the second music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary2 extends Diary2Shell{
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
        //Go to a Diary4 without an image

        String title = getTitle();
        String body = getBody();
        Diary4 d = new Diary4(title, body, null);
        Executable e = new ExecuteToTempState(d);
        postButton.setExecutable(e);
        add(postButton);
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
