package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteCancelRecording;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteRecord;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendAudioMessage;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendMessage;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateMessages;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteReset;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.serverClientInteractions.SocialContentTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import server.model.media.MAudio;
import server.model.social.MConversation;
import tools.utilities.Utils;

import java.util.List;

public class Friends2 extends Friends2Shell{
    //Stuff
    private long conversation;
    private List<Long> messageKeys = Utils.<Long>newList();

    public List<Long> getMessageKeys() {
        return messageKeys;
    }

    public long getConversation() {
        return conversation;
    }


    private ScrollPane scrollpane;
    private TextField messageField;

    public ScrollPane getScrollpane() {
        return scrollpane;
    }

    private Executable updatePage;
    private long counter;
    private String friendName;
    private Table table;

    public Friends2(String friendName){
        this.friendName = friendName;
        init();

    }

    private void initititititit(){
        SocialContentTalker sct = TalkerFactory.getSocialContentTalker();

        sct.init();
        sct.update(0);

        List<MConversation> convoList = sct.getConversations();

        int userKey = TalkerFactory.getMessagesTalker().indexByFriend(friendName);

        conversation = convoList.get(userKey).getKey();
    }

    protected void init(){
        super.init();

        addMessageField();

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 122 * StateManager.M, 750 * StateManager.M, 1095 * StateManager.M);

        stage.addActor(scrollpane);

        setUpRecord();

        Button sendButton = new Button(this);
        sendButton.setBounds(604 + 1, 31, 122, 60);
        ExecutableMultiplexer em3 = new ExecutableMultiplexer();
        em3.addExecutable(new ExecuteSendMessage(this));
        em3.addExecutable(new ExecuteReset(this));
        sendButton.setExecutable(em3);
        add(sendButton);

        updatePage = new ExecuteUpdateMessages(this);



        initititititit();
    }


    private void setUpRecord(){
        //This section initializes the DragButton
        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));
        DragButton dragButton = new DragButton(this, (int)(500*M), image, getStage());
        dragButton.setInitialBounds(32, 98, 750 - 64, 236);
        dragButton.setReleaseExecutable(new ExecuteSendAudioMessage(this));
        dragButton.setDragExecutable(new ExecuteCancelRecording());
        add(dragButton);
        //---------------------------------------------------------------------------------

        //This section initializes the RecordButton
        Button recordButton = new Button(this);
        recordButton.setBounds(32, 31, 122, 60);

        ExecutableMultiplexer em = new ExecutableMultiplexer();
        em.addExecutable(new ExecuteRecord());
        em.addExecutable(new ExecuteAddDragButton(dragButton));
        recordButton.setExecutable(em);
        add(recordButton);
        //---------------------------------------------------------------------------------

    }




    public void addMessage(MessageBox box){
        table.add(box.getTable()).width(480 * StateManager.M).padTop(56 * StateManager.M).left().padLeft((32 + 214 * box.getByUser()) * StateManager.M);
        table.row().expandX();
        scrollpane.layout();
        scrollpane.setScrollPercentY(100);
        stage.act();

        //new ExecuteSendAudioMessage(this, box).execute();
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

        messageField.getText();
        if (counter%10 == 0){
            this.updatePage.execute();
        }
        counter ++;
    }

    public void addAudioMessage(MAudio audio, int userType){
        ExecutePlayMAudio executePlayMAudio = new ExecutePlayMAudio(audio);
        MessageBox soundBox = new MessageBox(executePlayMAudio, userType, audio, "timestamp");

        this.addMessage(soundBox);
    }

    public void addTextMessage(String text, int userType){
        MessageBox box = new MessageBox(text, userType, "timestamp");

        this.addMessage(box);
    }



    public String getMessage(){
        return messageField.getText();
    }

}