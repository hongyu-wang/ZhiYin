package client.pages.other;

import client.component.basicComponents.ConfirmDialog;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.schmoferMusicExecutable.*;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendSnapChat;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateComments;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Gesturable;
import client.stateInterfaces.HasPlayButtons;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.AudioTools.AudioManager;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.utilities.Utils;

import java.util.List;


/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Picture co-ords: TopLeft: 49, 193
 *                  BottomRight:  706, 847
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends State implements Gesturable, HasPlayButtons {
    private ExecuteMoveSlider executeMoveSlider;
    private State previousState;
    private Slider slider;
    private boolean verbose;
    private Label totalTime;
    private Label currentTime;
    private long iterations;

    private MMusic post;

    private Image play;
    private Image pause;

    private Table create;
    private Table showComments;
    private Image filter;
    private Image picture;

    private String songName;

    private ExecuteUpdate update1;
    private ExecuteUpdate update2;
    private ExecuteToTempState backEx;
    private ExecuteToTempState commentEx;
    private ExecuteToTempState secEx;

    public NowPlaying(State previousState, MMusic post){
        this.previousState = previousState;
        this.songName = post.getName();
        verbose = false;
        this.post = post;
        init();
    }

    protected void initAlbumArt(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        
        MImage image = localDatabase.getModel(post.getAlbumArt());

        byte [] bytes = image.getImage();

        Pixmap px = new Pixmap(bytes, 0, bytes.length);
        disposables.add(px);
        Texture albumArt = new Texture(px);
        disposables.add(tx);
        disposables.add(albumArt);



        filter = new Image(tx = new Texture("Filter.png"));
        disposables.add(tx);

        filter.setColor(1, 1, 1, 0.9F);
        filter.setBounds((50) * M, (1160 - 655) * M, (655) * M, (655) * M);


        picture = new Image(albumArt);
        picture.setBounds((50) * M, (1160 - 655) * M, (655) * M, (655) * M);
        stage.addActor(picture);
    }


    @Override
    protected void init() {
        super.init();

        this.transitionType = TransitionType.RIGHT_TO_LEFT;

        //Standard Back Button Here.
        backEx = new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Table t = new Table();
        t.setBounds(200*M, 1160*M, 350*M, 150*M);
        t.add(new Label(songName, SkinSingleton.getInstance())).expand().center();
        stage.addActor(t);

        //-------------------------Sound Control System-----------------------------------------
        //-----
        TestExecutable rewindEx = new TestExecutable("rewind");  //TODO Implement Skip functionality here.
        addImage("NowPlaying/Rewind@", rewindEx, 170, 246, 53, 46);

        TestExecutable forwardEx = new TestExecutable("forward");
        addImage("NowPlaying/Forward@", forwardEx, 535, 246, 53, 46);

        initStatics();
        stage.addActor(pause);
        //------------------------------------------------------------------------------------------



        //--------------------------------The Two Transition Buttons----------------------------------------------
        Comment comment = new Comment(this, post);

        Sec1 sec1 = new Sec1(this, post);

        commentEx = new ExecuteToTempState(comment, TransitionType.DOWN_TO_UP);
        addImage("NowPlaying/Comment@", commentEx, 0, 0, 230, 117);

        secEx = new ExecuteToTempState(sec1, TransitionType.DOWN_TO_UP);
        addImage("NowPlaying/1s@", secEx, 230, 0, 290, 117);

        this.update1 = new ExecuteUpdateComments(comment, sec1);

        //---------------------------------------------------------------------------------------------

        initializeSlider();

        addMusicLabels();

        initializeComments();

        initAlbumArt();

        setUpSnapChat();
    }

    public void initStatics(){
        if(play == null || pause == null){
            pause = new Image(tx = new Texture("NowPlaying/Pause@1.0.png"));
            disposables.add(tx);
            pause.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    pause();
                    new ExecutePlayMusic().execute();
                }
            });
            pause.setBounds(288*M, 177*M, 180*M, 180*M);

            play = new Image(tx = new Texture("NowPlaying/Play@1.0.png"));
            disposables.add(tx);
            play.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    play();
                    new ExecutePlayMusic().execute();
                }
            });
            play.setBounds(288 * M, 177 * M, 180 * M, 180 * M);
        }
    }

    public void pause(){
        pause.remove();
        stage.addActor(play);
    }

    public void play(){
        play.remove();
        stage.addActor(pause);
    }



    @Override
    public void update(float dt){
        super.update(dt);
        if (iterations%60 == 0)
            executeMoveSlider.execute();
        if (os == MAC)
            updateMusicLabels(AudioManager.getTime());
        iterations ++;
    }


    private void setUpSnapChat(){
        //TODO setup this button.
        DragButton snapChat = new DragButton(this, 250, new Image(tx = new Texture("Friends/SwipeToDiscardButton@1.0.png")), getStage());
        disposables.add(tx);
        snapChat.setInitialBounds(32, 135, 750 - 64, 236);

        ConfirmDialog dialog = setUpWindows();

        ExecutableMultiplexer release = new ExecutableMultiplexer(
                new ExecuteStopSnapChat(),
                () -> stage.addActor(dialog.getWindow())
        );

        snapChat.setDragExecutable(new ExecuteStopSnapChat());
        snapChat.setReleaseExecutable(release);
        add(snapChat);

        //-----------------------This is the share button that adds the drag button
        ExecutableMultiplexer em = new ExecutableMultiplexer(
                new ExecuteAddDragButton(snapChat),
                new ExecuteRecord(),
                new ExecuteStartSnapChat()
        );
        addImage("NowPlaying/Share@", em, 520, 0, 230, 117);
    }

    private ConfirmDialog setUpWindows(){
        List<String> names = Utils.newList();
        List<Executable> exs = Utils.newList();

        FriendTalker ft = TalkerFactory.getFriendTalker();
        ProfileTalker pt = TalkerFactory.getProfileTalker();
        for(User friend: ft.getAllFriends()){
            pt.init(friend);
            names.add(pt.getName());
            exs.add(new ExecuteSendSnapChat(pt.getName()));
        }

        UserProfile profile = LocalDatabaseFactory.createLocalDatabase().getModel(LocalDatabaseFactory.createLocalDatabase().getMainUser().getProfileKey());

        names.add(profile.getUsername());
        exs.add(new ExecuteSendSnapChat(profile.getUsername()));

        ConfirmDialog confirmDialog = new ConfirmDialog(
                "You've created a new snapshot!! Which of your friends do you want to send it to?",
                names.toArray(new String[names.size()])
        );
        confirmDialog.setUpExecutables(
                exs.toArray(new Executable[exs.size()])
        );

        return confirmDialog;
    }


    private void initializeComments(){
        Executable addCommentEx = new TestExecutable("addANewComment");
        create = createImage("NowPlaying/AddComment@", addCommentEx, 537, 1063, 51, 51);

        Executable showCommentsEx = () -> {

            setUpScrollingComments();
            verbose = !verbose;

        };

        showComments = createImage("NowPlaying/ShowComments@", showCommentsEx, 607, 1063, 51, 51);
        stage.addActor(showComments);

    }

    private void setUpScrollingComments() {
        if (!verbose) {
            stage.addActor(create);
            showComments.remove();
            stage.addActor(filter);
            stage.addActor(showComments);
            stage.addActor(create);
        } else{
            filter.remove();
            create.remove();
            stage.addActor(picture);
            showComments.remove();
            stage.addActor(showComments);
        }
    }

    public void initializeSlider(){
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());
        Table table = new Table();
        table.add(slider).minWidth(660*M);
        table.setBounds(45*M, 400*M, 660*M, 20*M);

        slider.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteSetTime(slider).execute();
            }
        });
        executeMoveSlider = new ExecuteMoveSlider(slider);

        stage.addActor(table);
    }

    private void addMusicLabels(){
        currentTime = new Label("0:00", SkinSingleton.getInstance());
        totalTime = new Label("", SkinSingleton.getInstance());
        currentTime.setBounds(60*M, 420*M, currentTime.getPrefWidth(), currentTime.getPrefHeight());
        totalTime.setBounds((WIDTH - 100 - totalTime.getPrefWidth())*M, 420*M, currentTime.getPrefWidth(), currentTime.getPrefHeight());
        stage.addActor(totalTime);
        stage.addActor(currentTime);
    }

    public void updateMusicLabels(double time){
        currentTime.setText(convertToMinutes(time));

        String total = convertToMinutes(AudioManager.trackLength());
        totalTime.setText(total);
    }

    public static String convertToMinutes(double timeInSeconds){
        int time = (int)timeInSeconds;

        int minutes = time/60;
        int seconds = time%60;
        if (seconds < 10)
            return minutes+":0"+seconds;
        return minutes+":"+seconds;
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if (gestureYUp && !directionMainlyX)
            commentEx.execute();
    }

    @Override
    public void resetPlayButtons() {
        this.play();
    }
}
