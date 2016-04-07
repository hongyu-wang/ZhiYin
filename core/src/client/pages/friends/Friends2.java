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
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateMessages;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.friends.boxes.MessageBox;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import server.model.media.MAudio;
import tools.utilities.Utils;

import java.util.List;

public class Friends2 extends Friends2Shell implements Gesturable{
    private List<Long> messageKeys;
    public List<Long> getMessageKeys(){
        return messageKeys;
    }

    private ScrollPane scrollpane;
    public ScrollPane getScrollpane() {
        return scrollpane;
    }

    private String friendName;
    public String getFriendName(){
        return friendName;
    }

    private State previousState;

    private TextField messageField;
    private Table table;

    private ExecuteUpdate update;

    public Friends2(State previousState, String friendName){
        this.previousState = previousState;
        this.friendName = friendName;
        this.messageKeys = Utils.newList();
        init();
    }

    protected void init(){
        super.init();

        //Required for updating this page from another source.
        this.update = new ExecuteUpdateMessages(this);

        addMessageField();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Table t = new Table();
        t.setBounds(117*M, 1217*M, 516*M, 117*M);
        t.add(new Label(friendName, SkinSingleton.getInstance())).center();
        stage.addActor(t);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 122*M, 750*M, 1095*M);

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
        Image image = new Image(tx = new Texture("Friends/SwipeToDiscardButton@1.0.png"));
        disposables.add(tx);
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
        table.add(box.getTable()).width(480*M).padTop(56*M).left().padLeft((32 + 214 * box.getByUser())*M);
        table.row().expandX();
        scrollpane.layout();
        scrollpane.setScrollPercentY(100);
        disposables.add(box);
        //new ExecuteSendAudioMessage(this, box).execute();
    }

    @Override
    public void reset() {
        super.reset();
        messageField.remove();
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(174*M, 31*M);
        messageField.setSize(412*M, 60*M);

        stage.addActor(messageField);
    }

    @Override
    public void update(float dt){
        super.update(dt);
    }



    private void addMessageField(){
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(174*M, 31*M);
        messageField.setSize(412*M, 60*M);
        stage.addActor(messageField);
    }


    public void addAudioMessage(MAudio audio, int userType, String timestamp){
        ExecutePlayMAudio executePlayMAudio = new ExecutePlayMAudio(audio);
        MessageBox soundBox = new MessageBox(executePlayMAudio, userType, audio, friendName, timestamp);

        this.addMessage(soundBox);
    }

    public void addTextMessage(String text, int userType, String timestamp){
        MessageBox box = new MessageBox(text, userType, friendName, timestamp);

        this.addMessage(box);
    }

    public String getMessage(){
        return messageField.getText();
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT).execute();
    }
}