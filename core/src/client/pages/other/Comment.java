package client.pages.other;

import client.events.executables.internalChanges.serverInteractions.ExecuteSendComment;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Comment extends CommentShell implements Gesturable{
    private long thisPost;

    private List<Long> currentComments;

    private State previousState;

    private String title;
    private String subtitle;

    private WorkingTextArea messageField;

    private ScrollPane scrollpane;
    private Table comments;
    private ExecuteToTempState backEx;

    public Comment(State previousState, MMusic post){
        this.previousState = previousState;

        this.thisPost = post.getKey();
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        this.subtitle = post.getArtist();
        init();
    }

    public Comment(State previousState, MDiaryPost post){
        this.previousState = previousState;
        this.thisPost = post.getKey();
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        MText tempText = LocalDatabaseFactory.createLocalDatabase().getModel(post.getText());
        this.subtitle = tempText.getText();
        init();
    }

    public void init(){
        super.init();
        transitionType = TransitionType.UP_TO_DOWN;
        addMessageField();

        backEx = new ExecuteToTempState(previousState, TransitionType.UP_TO_DOWN);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        initTable();

        comments = new Table();
        comments.top();

        scrollpane = new ScrollPane(comments);
        scrollpane.setBounds(0, 122*M, 750*M, 878*M);
        stage.addActor(scrollpane);

        ExecuteSendComment sendEx = new ExecuteSendComment(this);
        addImage("Other/Send@", sendEx, 604, 32, 122, 60);
    }

    private void initTable(){
        Label label1 = new Label(title, SkinSingleton.getInstance());
        Label label2 = new Label(subtitle, SkinSingleton.getInstance());

        Table table = new Table();
        table.setBounds(0, 1000*M, 750*M, 217*M);
        table.add(label1).expand();
        table.row();
        table.add(label2).expand();
        stage.addActor(table);
    }

    private void addMessageField(){
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(32*M, 31*M);
        messageField.setSize(554*M, 60*M);

        stage.addActor(messageField);
    }

    public void addComment(String name, String time, String comment){
        Table t = new Table();
        Label label1 = new Label(name, SkinSingleton.getInstance());
        Label label2 = new Label(time, SkinSingleton.getInstance());
        Label label3 = new Label(comment, SkinSingleton.getInstance());
        label3.setWrap(true);
        label3.setWidth(700 * StateManager.M);
        Image line = new Image(tx = new Texture("Home/Line@1.0.png"));
        disposables.add(tx);

        t.add(label1).expand().left().padLeft(50*M).padTop(50*M);
        t.add(label2).expand().right().padRight(50*M).padTop(50*M);
        t.row();
        t.add(label3).width(700*M).left().padLeft(50*M);
        t.row();
        t.add(line).width(750*M).height(4*M).padLeft(100*M).padTop(50*M);

        comments.add(t).width(750*M);
        comments.row();
    }

    private void send(){
        String message = getMessage();
        if(!message.equals("")){
            addComment("name", "time", message);
            reset();
        }
    }

    @Override
    public void reset() {
        super.reset();
        messageField.remove();
        addMessageField();
    }



    public void update(float fy){
        super.update(fy);

        pullData();
    }

    public String getMessage(){
        return messageField.getText();
    }

    private void pullData(){
        pullCommentsFromServer();
    }

    private void pullCommentsFromServer(){

    }

    public long getThisPost(){
        return thisPost;
    }


    public List<Long> getCurrentComments() {
        return currentComments;
    }

    public Table getComments() {
        return comments;
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if (!gestureYUp && !directionMainlyX)
            backEx.execute();
    }
}
