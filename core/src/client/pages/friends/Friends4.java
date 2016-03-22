package client.pages.friends;


import client.pages.friends.boxes.MessageBox;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

import static client.singletons.StateManager.M;

public class Friends4 extends Friends4Shell{
    private TextField messageField;

    public void init(){
        super.init();

        addMessageField();

        MessageBox box1 = new MessageBox("This is a long message made for the sole purpose of testing our stuff. Please do not read this unless you want to waste your time." +
                "Why are you still reading this? Do you really have nothing better to do right now? Go find yourself a hobby or something. That, or go do some work." +
                "Just stop reading this really long string. Please. And thank you.", 0);
//        MessageBox box2 = new MessageBox("This is a long message made for the sole purpose of testing our stuff.", 1);
//        MessageBox box3 = new MessageBox("Message", 0);
        stage.addActor(box1.getStack());
//        stage.addActor(box2.getStack());
//        stage.addActor(box3.getStack());

        /*MessageBox box2 = new MessageBox("String", 1334 - 150  * 3, 1);
        stage.addActor(box2.getStack());

        MessageBox box3 = new MessageBox(new TestExecutable("clicked 1"), 1334 - 150  * 4, 0);
        stage.addActor(box3.getStack());

        MessageBox box4 = new MessageBox(new TestExecutable("clicked 2"), 1334 - 150  * 5, 1);
        stage.addActor(box4.getStack());*/

    }

    @Override
    public void reset() {
        messageField.remove();
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition((26 + 1) * M, 31 * M);
        messageField.setSize(560 * M, 60 * M);

        stage.addActor(messageField);
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