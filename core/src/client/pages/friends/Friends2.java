package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteCancelRecording;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteRecord;
import client.events.executables.internalChanges.serverInteractions.*;
import client.pages.friends.boxes.MessageBox;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import server.model.media.MAudio;
import server.model.media.MSnapShot;
import tools.utilities.Utils;

import java.util.List;

public class Friends2 extends Friends2Shell{
    private List<Long> messageKeys;

    public List<Long> getMessageKeys(){
        return messageKeys;
    }


    private ScrollPane scrollpane;
    private TextField messageField;

    public ScrollPane getScrollpane() {
        return scrollpane;
    }

    private String friendName;


    public String getFriendName(){
        return friendName;
    }

    private Table table;



    private ExecuteUpdate update;

    public Friends2(String friendName){
        this.friendName = friendName;
        this.messageKeys = Utils.newList();
        init();

    }



    protected void init(){
        super.init();

        //Required for updating this page from another source.
        this.update = new ExecuteUpdateMessages(this);

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
        em3.addExecutable(this::reset);
        sendButton.setExecutable(em3);
        add(sendButton);
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

        //new ExecuteSendAudioMessage(this, box).execute();
    }

    @Override
    public void reset() {
        super.reset();
        messageField.remove();
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(174 * M, 31 * M);
        messageField.setSize(412 * M, 60 * M);

        stage.addActor(messageField);
    }

    @Override
    public void update(float dt){
        super.update(dt);
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


    public void addAudioMessage(MAudio audio, int userType, String timestamp){
        ExecutePlayMAudio executePlayMAudio = new ExecutePlayMAudio(audio);
        MessageBox soundBox = new MessageBox(executePlayMAudio, userType, audio, timestamp);

        this.addMessage(soundBox);
    }

    public void addTextMessage(String text, int userType, String timestamp){
        MessageBox box = new MessageBox(text, userType, timestamp);

        this.addMessage(box);
    }

    public String getMessage(){
        return messageField.getText();
    }

}