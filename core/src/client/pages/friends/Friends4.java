package client.pages.friends;


import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

import static client.singletons.StateManager.M;

public class Friends4 extends Friends4Shell{
    private TextField messageField;

    public void init(){
        super.init();

        addMessageField();
    }

    @Override
    public void dispose() {

    }

    private void addMessageField(){
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition((26 + 1) * M, 31 * M);
        messageField.setSize(560 * M, 60 * M);

        stage.addActor(messageField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        messageField.getText();//TODO something
    }

}