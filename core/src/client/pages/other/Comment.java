package client.pages.other;

import client.events.executables.internalChanges.serverInteractions.ExecuteSendComment;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MDiaryPost;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Comment extends CommentShell {
    private MPost thisPost;

    private List<Long> currentComments;

    private State previousState;

    private String title;
    private String subtitle;

    private WorkingTextArea messageField;

    private ScrollPane scrollpane;
    private Table comments;

    public Comment(State previousState, MMusic post){
        this.previousState = previousState;

        this.thisPost = post;
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        this.subtitle = post.getArtist();
        init();
    }


    public Comment(State previousState, MDiaryPost post){
        this.previousState = previousState;
        this.thisPost = post;
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        MText tempText = LocalDatabaseFactory.createLocalDatabase().getModel(post.getText());
        this.subtitle = tempText.getText();
        init();
    }

    public void init(){
        super.init();

        addMessageField();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        initTable();

        comments = new Table();
        comments.top();

        scrollpane = new ScrollPane(comments);
        scrollpane.setBounds(0, 122 * StateManager.M, 750 * StateManager.M, 878 * StateManager.M);
        stage.addActor(scrollpane);

        ExecuteSendComment sendEx = new ExecuteSendComment(this);
        ImageButton sendButton = createImageButton("Other/Send@", sendEx, 604, 32, 122, 60);
//        sendButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                send();
//            }
//        });
        stage.addActor(sendButton);
    }

    private void initTable(){
        Label label1 = new Label(title, SkinSingleton.getInstance());
        Label label2 = new Label(subtitle, SkinSingleton.getInstance());

        Table table = new Table();
        table.setBounds(0, 1000 * StateManager.M, 750 * StateManager.M, 217 * StateManager.M);
        table.add(label1).expand();
        table.row();
        table.add(label2).expand();
        stage.addActor(table);
    }

    private void addMessageField(){
        messageField = new WorkingTextArea("Message...", SkinSingleton.getInstance());
        messageField.setPosition(32 * M, 31 * M);
        messageField.setSize(554 * M, 60 * M);

        stage.addActor(messageField);
    }

    public void addComment(String name, String time, String comment){
        Table t = new Table();
        Label label1 = new Label(name, SkinSingleton.getInstance());
        Label label2 = new Label(time, SkinSingleton.getInstance());
        Label label3 = new Label(comment, SkinSingleton.getInstance());
        label3.setWrap(true);
        label3.setWidth(700 * StateManager.M);
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(label1).expand().left().padLeft(50 * StateManager.M).padTop(50 * StateManager.M);
        t.add(label2).expand().right().padRight(50 * StateManager.M).padTop(50 * StateManager.M);
        t.row();
        t.add(label3).width(700 * StateManager.M).left().padLeft(50 * StateManager.M);
        t.row();
        t.add(line).width(750 * StateManager.M).padLeft(100 * StateManager.M).padTop(50 * StateManager.M);

        comments.add(t).width(750 * StateManager.M);
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
        messageField.remove();
        addMessageField();
    }



    @Override
    public void dispose() {

    }

    public void update(float fy){
        stage.act();

        pullData();
    }

    public String getMessage(){
        return messageField.getText();
    }

    private void pullData(){
        pullCommentsFromServer();
    }

    private void pullCommentsFromServer(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        List<Long> commentKeys = thisPost.getComments();

        for(long key: commentKeys){
            if(!currentComments.contains(key)){

                MComment comment = localDatabase.getModel(key);

                if(comment.getAudio().size() > 0){
                    continue;
                }

                String text = comment.getText();

                User user = localDatabase.getModel(comment.getCreator());
                UserProfile profile = localDatabase.getModel(user.getProfile());

                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                Date df = new Date(comment.getTimeStamp());
                String timestamp = sdf.format(df);

                addComment(profile.getUsername(), timestamp, text);

                currentComments.add(key);
            }
        }
    }

    public MPost getThisPost() {
        return thisPost;
    }

    public List<Long> getCurrentComments() {
        return currentComments;
    }

    public Table getComments() {
        return comments;
    }
}
