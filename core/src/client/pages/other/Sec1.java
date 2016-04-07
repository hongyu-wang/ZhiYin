package client.pages.other;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteCancelRecording;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteRecord;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendAudioComment;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MAudio;
import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.social.MPost;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Sec1 extends Sec1Shell implements Gesturable{
    private MPost thisPost;

    public List<Long> getCurrentComments() {
        return currentComments;
    }

    private List<Long> currentComments;

    public MPost getThisPost(){
        return thisPost;
    }

    private ImageButton holdToRecordButton;

    private State previousState;

    private ScrollPane scrollpane;
    private Table posts;

    private String title;
    private String subtitle;

    //private DragButton dragButton;
    private ExecuteToTempState backEx;

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
        MText tempText = LocalDatabaseFactory.createLocalDatabase().getModel(post.getText());
        this.subtitle = tempText.getText();
        init();
    }
    protected void init(){
        super.init();

        backEx = new ExecuteToTempState(previousState, TransitionType.UP_TO_DOWN);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Image image = new Image(tx = new Texture("Friends/SwipeToDiscardButton@1.0.png"));
        image.setBounds(26*M, 130*M, 698*M, 236*M);

        Table t = new Table();
        t.setBounds(26*M, 57*M, 698*M, 58*M);
        t.add(new Image(tx = new Texture("Other/HoldToRecord@1.0.png"))).center();

        DragButton dragButton = new DragButton(this, 280, image, getStage());
        dragButton.setInitialBounds(26, 130, 698, 236);

        dragButton.setDragExecutable(new ExecuteCancelRecording());

        dragButton.setReleaseExecutable(new ExecuteSendAudioComment(this));
        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(26, 57, 698, 58);

        holdToRecordButton.setExecutable(new ExecutableMultiplexer(
                        new ExecuteAddDragButton(dragButton),
                        new ExecuteRecord()
                )
        );

        stage.addActor(t);
        add(holdToRecordButton);

        initTable();

        posts = new Table();
        posts.top();

        scrollpane = new ScrollPane(posts);
        scrollpane.setBounds(0, 200*M, 750*M, 800*M);
        stage.addActor(scrollpane);
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

    public void addPost(String name, String time, MAudio audio){
        Label label1 = new Label(name + "\n" + time, SkinSingleton.getInstance());
        Image ripples = new Image(tx = new Texture("Friends/Ripples0@1.0.png"));
        disposables.add(tx);
        ImageButton playButton = new ImageButton(new Image(tx = new Texture("Friends/Play0@1.0.png")).getDrawable());
        disposables.add(tx);

        final ExecutePlayMAudio ex = new ExecutePlayMAudio(audio);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ex.execute();
            }
        });

        Image line = new Image(tx = new Texture("Home/Line@1.0.png"));
        disposables.add(tx);

        Table t = new Table();
        t.add(label1).expand().center().left().padLeft(50*M);
        t.add(ripples).width(328*M).height(66*M).center().padRight(100*M);
        t.add(playButton).width(68*M).height(68*M).center().padRight(50*M);//.padLeft(50 * StateManager.M);
        t.row();
        t.add(line).width(700*M).center().expandX().padLeft(600*M);

        posts.add(t).width(750*M).height(140*M);
        posts.row();
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if (!gestureYUp && !directionMainlyX){
            backEx.execute();
        }
    }
}
