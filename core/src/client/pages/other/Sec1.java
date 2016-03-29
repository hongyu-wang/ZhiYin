package client.pages.other;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddImage;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteRemoveDragButton;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteRemoveImage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MDiaryPost;
import server.model.social.MPost;
import tools.utilities.Utils;

import java.util.List;

import static client.singletons.StateManager.M;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Sec1 extends Sec1Shell {
    private MPost thisPost;
    private ImageButton holdToRecordButton;
    private List<Long> currentComments;

    private State previousState;

    private ScrollPane scrollpane;
    private Table posts;

    private String title;
    private String subtitle;

    //private DragButton dragButton;

    public Sec1(State previousState, MMusic post){
        this.previousState = previousState;

        this.thisPost = post;
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        this.subtitle = post.getArtist();
        init();
    }


    public Sec1(State previousState, MDiaryPost post){
        this.previousState = previousState;
        this.thisPost = post;
        currentComments = Utils.<Long>newList();
        this.title = post.getTitle();
        MText tempText = ModelStorageFactory.createModelStorage().getModel(post.getText());
        this.subtitle = tempText.getText();
        init();
    }
    protected void init(){
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));
        image.setBounds(26 * M, 130 * M, 698 * M, 236 * M);
        Image label = new Image(new Texture("Other/HoldToRecord@" + StateManager.M + ".png"));
        label.setPosition(260 * M, 65 * M);

        DragButton dragButton = new DragButton(this, (int)(400 * StateManager.M));
        dragButton.setBounds(0, 0, 0, 0);
        ExecutableMultiplexer em = new ExecutableMultiplexer();
        em.addExecutable(new ExecuteRemoveDragButton(dragButton));
        em.addExecutable(new ExecuteRemoveImage(image));
        em.addExecutable(new ExecuteAddImage(stage, label));
        dragButton.setDragExecutable(em);

        ExecutableMultiplexer em2 = new ExecutableMultiplexer();
        em2.addExecutable(new ExecuteRemoveDragButton(dragButton));
        em2.addExecutable(new ExecuteRemoveImage(image));
        em2.addExecutable(new ExecuteAddImage(stage, label));
        em2.addExecutable(new ExecuteToTempState(new Sec2(this, previousState)));
        dragButton.setReleaseExecutable(em2);
        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(26, 57, 698, 58);
        ExecutableMultiplexer recordEx = new ExecutableMultiplexer();
        recordEx.addExecutable(new ExecuteAddDragButton(dragButton, 26, 130, 698, 236));
        recordEx.addExecutable(new ExecuteAddImage(stage, image));
        recordEx.addExecutable(new ExecuteRemoveImage(label));
        holdToRecordButton.setExecutable(recordEx);

        stage.addActor(label);
        add(holdToRecordButton);

        initTable();

        posts = new Table();
        posts.top();

        scrollpane = new ScrollPane(posts);
        scrollpane.setBounds(0, 200 * StateManager.M, 750 * StateManager.M, 800 * StateManager.M);
        stage.addActor(scrollpane);

        addPost("name", "time");
        addPost("name", "time");
        addPost("name", "time");
        addPost("name", "time");
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

    public void addPost(String name, String time){
        Label label1 = new Label(name + "\n" + time, SkinSingleton.getInstance());
        Image ripples = new Image(new Texture("Friends4/Ripples0@" + StateManager.M + ".png"));
        ImageButton playButton = new ImageButton(new Image(new Texture("Friends4/Play0@" + StateManager.M + ".png")).getDrawable());
        final Executable e = new TestExecutable("play");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        Table t = new Table();
        t.add(label1).expand().center().left().padLeft(50 * StateManager.M);
        t.add(ripples).width(328 * StateManager.M).height(66 * StateManager.M).center().padRight(100 * StateManager.M);
        t.add(playButton).width(68 * StateManager.M).height(68 * StateManager.M).center().padRight(50 * StateManager.M);//.padLeft(50 * StateManager.M);
        t.row();
        t.add(line).width(700 * StateManager.M).center().expandX().padLeft(600 * StateManager.M);

        posts.add(t).width(750 * StateManager.M).height(140 * StateManager.M);
        posts.row();
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }

    private void pullData(){

    }

    private void pullCommentsFromServer(){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        java.util.List<Long> commentKeys = thisPost.getComments();

        boolean isUpdated = true;

        for(long key: commentKeys){
            MComment model = ms.getModel(key);
            if(model.getAudio().size() > 0){
                //TODO add comment
            }
        }
    }
}
