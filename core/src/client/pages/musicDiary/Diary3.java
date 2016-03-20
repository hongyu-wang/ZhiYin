package client.pages.musicDiary;

import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

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
    }

    private void addTitleField(){
        titleField = new TextField("Title...", SkinSingleton.getInstance());
        titleField.setPosition((0 + 1) * M, 1112 * M);
        titleField.setSize(750* M, 88 * M);

        stage.addActor(titleField);
    }

    private void addBodyField(){
        bodyField = new TextField("Text...", SkinSingleton.getInstance());
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
