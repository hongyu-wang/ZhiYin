package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteReset;
import client.events.executables.internalChanges.ExecuteToTempState;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.friends.boxes.MessageBox;
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

import static client.singletons.StateManager.M;

public class Friends2 extends Friends2Shell{

    private TextField messageField;

    private long counter;

    private Table table;

    public Friends2(){
        super();
    }

    public void init(){
        super.init();

        addMessageField();

        table = new Table();
        table.top();

        ScrollPane scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 122 * StateManager.M, 750 * StateManager.M, 1095 * StateManager.M);

        stage.addActor(scrollpane);

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

        addMessage(box1);
        addMessage(box2);
        addMessage(box3);
        addMessage(box4);
        addMessage(box5);
        addMessage(box6);
        addMessage(box7);
        addMessage(box8);


        Button sendButton = new Button(this);
        sendButton.setBounds(604 + 1, 31, 122, 60);
        sendButton.setExecutable(new ExecuteReset(this));
        add(sendButton);

        Button recordButton = new Button(this);
        recordButton.setBounds(32, 31, 122, 60);
        recordButton.setExecutable(new ExecuteToTempState(new Friends3(stage)));
        add(recordButton);
    }

    public void addMessage(MessageBox box){
        table.add(box.getStack()).width(240).padTop(28).left().padLeft((32 + 214 * box.getByUser()) * StateManager.M);
        table.row().expandX();
    }

    @Override
    public void reset() {
        messageField.remove();
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(174 * M, 31 * M);
        messageField.setSize(412 * M, 60 * M);

        stage.addActor(messageField);
    }

    @Override
    public void dispose() {

    }

    private void addMessageField(){
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(174 * M, 31 * M);
        messageField.setSize(412 * M, 60 * M);

        stage.addActor(messageField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        stage.act(); //This bug tho

        messageField.getText();//TODO something
//        if (counter%200 == 0){
//            SocialContentTalker sct = TalkerFactory.getSocialContentTalker();
//            sct.init();
//            sct.update(0);
//
//            MConversation fuck = sct.getConversations().get(0);
//
//            ConversationTalker talker = TalkerFactory.getMessagesTalker();
//
//            talker.init(fuck);
//            if(!talker.isWaiting())
//                talker.pull();
//            talker.update(0);
//
//            System.out.println("Here I am.");
//            for(MMessage message :talker.getAllMMessages()){
//                System.out.println(talker.getMessageText(message));
//            }
//
//        }
//        counter ++;
    }


    public void talkerTest(){
        String message = "fuck you Kevin Zheng";

        SocialContentTalker sct = TalkerFactory.getSocialContentTalker();
        sct.init();

        sct.update(0);

        MConversation fuck = sct.getConversations().get(0);

        ConversationTalker talker = TalkerFactory.getMessagesTalker();

        talker.init(fuck);

        talker.update(0);

        talker.newMessage(message);

        talker.push();

    }

}