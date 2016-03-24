package client.pages.friends;


import client.events.executables.internalChanges.TestExecutable;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.pages.pageInternal.serverClientInteractions.ConversationTalker;
import client.pages.pageInternal.serverClientInteractions.SocialContentTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.user.UserConversations;
import server.services.interfaces.models.ConversationManager;

import java.util.Arrays;
import java.util.List;

import static client.singletons.StateManager.M;

public class Friends4 extends Friends4Shell{
    private TextField messageField;
    private int counter = 0;
    public void init(){
        super.init();

        addMessageField();

        MessageBox box1 = new MessageBox("This is a long message made for the sole purpose of testing our stuff. Please do not read this unless you want to waste your time." +
                "Why are you still reading this? Do you really have nothing better to do right now? Go find yourself a hobby or something. That, or go do some work." +
                "Just stop reading this really long string. Please. And thank you.", 0);
        MessageBox box2 = new MessageBox("This is a long message made for the sole purpose of testing our stuff.", 1);
        MessageBox box3 = new MessageBox("Message", 0);
        MessageBox box4 = new MessageBox("String", 1);

        MessageBox box5 = new MessageBox(new TestExecutable("clicked 1"), 0);
        MessageBox box6 = new MessageBox(new TestExecutable("clicked 2"), 1);
        MessageBox box7 = new MessageBox(new TestExecutable("clicked 3"), 0);
        MessageBox box8 = new MessageBox(new TestExecutable("clicked 4"), 1);

        Table table = new Table();
        ScrollPane scrollpane = new ScrollPane(table);

        table.add(box1.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box1.getByUser()) * StateManager.M);
        table.row();
        table.add(box2.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box2.getByUser()) * StateManager.M);
        table.row();
        table.add(box3.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box3.getByUser()) * StateManager.M);
        table.row();
        table.add(box4.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box4.getByUser()) * StateManager.M);
        table.row();
        table.add(box5.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box5.getByUser()) * StateManager.M);
        table.row();
        table.add(box6.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box6.getByUser()) * StateManager.M);
        table.row();
        table.add(box7.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box7.getByUser()) * StateManager.M);
        table.row();
        table.add(box8.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box8.getByUser()) * StateManager.M);
        table.row().expandX();

        table.top();

        //table.setDebug(true);

        scrollpane.setBounds(0, 122 * StateManager.M, 750 * StateManager.M, 1212 * StateManager.M);

        stage.addActor(scrollpane);



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

        stage.act(); //This bug tho

        messageField.getText();//TODO something
        if (counter%1000 == 0){
            SocialContentTalker sct = TalkerFactory.getSocialContentTalker();
            sct.update(0);

            MConversation fuck = sct.getConversations().get(0);

            ConversationTalker talker = TalkerFactory.getMessagesTalker();

            talker.init(fuck);

            talker.update(0);

            for(MMessage message :talker.getAllMMessages()){
                System.out.println(talker.getMessageText(message));
            }

        }
        counter ++;

    }


    public void talkerTest(){
        String message = "fuck you Kevin Zheng";

        SocialContentTalker sct = TalkerFactory.getSocialContentTalker();
        sct.update(0);

        MConversation fuck = sct.getConversations().get(0);

        ConversationTalker talker = TalkerFactory.getMessagesTalker();

        talker.init(fuck);

        talker.update(0);

        talker.newMessage(message);

        talker.push();

    }

}