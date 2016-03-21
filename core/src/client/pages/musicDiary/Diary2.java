package client.pages.musicDiary;

import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
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

    public void init() {
        super.init();

        addTitleField();
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
