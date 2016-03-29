package client.pages.other;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.social.MPost;
import java.util.List;

import tools.utilities.Utils;

import static client.singletons.StateManager.M;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Comment extends CommentShell {
    private MPost thisPost;

    private List<Long> currentComments;

    private State previousState;

    private String title;
    private String subtitle;

    private TextField messageField;

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
        MText tempText = ModelStorageFactory.createModelStorage().getModel(post.getText());
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

        TestExecutable sendEx = new TestExecutable("send");
        ImageButton sendButton = createImageButton("Other/Send@", sendEx, 604, 32, 122, 60);
        sendButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                send();
            }
        });
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
        System.out.println("message: " + message);
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
    }

    public String getMessage(){
        return messageField.getText();
    }

    private void pullData(){

    }

    private void pullCommentsFromServer(){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        List<Long> commentKeys = thisPost.getComments();

        boolean isUpdated = true;

        for(long key: commentKeys){
            if(!currentComments.contains(key)){


                currentComments.add(key);
            }
        }
    }
}
