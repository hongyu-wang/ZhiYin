package client.pages.other;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteCancelRecording;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecutePlayMAudio;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteRecord;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendAudioComment;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import server.model.media.MAudio;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
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

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Sec1 extends Sec1Shell {
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

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));
        image.setBounds(26 * M, 130 * M, 698 * M, 236 * M);
        Image label = new Image(new Texture("Other/HoldToRecord@" + StateManager.M + ".png"));
        label.setPosition(260 * M, 65 * M);

        DragButton dragButton = new DragButton(this, 280, image, getStage());
        dragButton.setInitialBounds(26, 130, 698, 236);

        dragButton.setDragExecutable(new ExecuteCancelRecording());

        dragButton.setReleaseExecutable(new ExecutableMultiplexer(
                new ExecuteToTempState(
                        new Sec2(this, previousState)

                    )
                )
        );
        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(26, 57, 698, 58);

        holdToRecordButton.setExecutable(new ExecutableMultiplexer(
                        new ExecuteAddDragButton(dragButton),
                        new ExecuteRecord()
                )

        );

        stage.addActor(label);
        add(holdToRecordButton);

        initTable();

        posts = new Table();
        posts.top();

        scrollpane = new ScrollPane(posts);
        scrollpane.setBounds(0, 200 * StateManager.M, 750 * StateManager.M, 800 * StateManager.M);
        stage.addActor(scrollpane);
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

    public void addPost(String name, String time, MAudio audio){
        Label label1 = new Label(name + "\n" + time, SkinSingleton.getInstance());
        Image ripples = new Image(new Texture("Friends4/Ripples0@" + StateManager.M + ".png"));
        ImageButton playButton = new ImageButton(new Image(new Texture("Friends4/Play0@" + StateManager.M + ".png")).getDrawable());

        final ExecutePlayMAudio ex = new ExecutePlayMAudio(audio);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ex.execute();
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
    public void dispose() {

    }

    private void pullData(){

    }

    private void pullCommentsFromServer(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        java.util.List<Long> commentKeys = thisPost.getComments();

        boolean isUpdated = true;

        for(long key: commentKeys){
            MComment model = localDatabase.getModel(key);
            if(model.getAudio().size() > 0){
                //TODO add comment
            }
        }
    }
}
