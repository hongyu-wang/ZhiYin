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
import client.stateInterfaces.Gesturable;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
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
public class NowPlaying extends State implements Gesturable{
    private ExecuteMoveSlider executeMoveSlider;
    private State previousState;
    private Slider slider;
    private boolean verbose;
    private Label totalTime;
    private Label currentTime;
    private long iterations;

    private MMusic post;

    private static Image play;
    private static Image pause;
    private static Image playPause;
    private static boolean playing;

    private Table create;
    private Table showComments;
    private Image filter;
    private Image picture;

    private String songName;

    private ExecuteUpdate update1;
    private ExecuteUpdate update2;
    private ExecuteToTempState backEx;

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

        Texture albumArt = new Texture(px);
        px.dispose();


        filter = new Image(new Texture("Filter.png"));
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
        backEx = new ExecuteToTempState(previousState, this);
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

        play = new Image(new Texture("NowPlaying/Play@1.0.png"));
        pause = new Image(new Texture("NowPlaying/Pause@1.0.png"));
        playPause = new Image();
        playing = true;
        pause();

        Table t2 = new Table();
        t2.setBounds(288*M, 177*M, 180*M, 180*M);
        t2.add(playPause).width(180*M).height(180*M);
        stage.addActor(t2);
        //------------------------------------------------------------------------------------------



        //--------------------------------The Two Transition Buttons----------------------------------------------
        Comment comment = new Comment(this, post);

        Sec1 sec1 = new Sec1(this, post);

        ExecuteToTempState commentEx = new ExecuteToTempState(comment, this);
        addImage("NowPlaying/Comment@", commentEx, 0, 0, 230, 117);

        ExecuteToTempState secEx = new ExecuteToTempState(sec1, this);
        addImage("NowPlaying/1S@", secEx, 230, 0, 290, 117);

        this.update1 = new ExecuteUpdateComments(comment, sec1);

        //---------------------------------------------------------------------------------------------

        initializeSlider();

        addMusicLabels();

        initializeComments();

        initAlbumArt();

        setUpSnapChat();
    }

    public static void pause(){
        if(playing) {
            playPause.setDrawable(pause.getDrawable());
            playPause.clearListeners();
            playPause.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    play();
                    new ExecutePlayMusic().execute();
                }
            });

            playing = !playing;
        }
    }

    public static void play(){
        if(!playing) {
            playPause.setDrawable(play.getDrawable());
            playPause.clearListeners();
            playPause.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    pause();
                    new ExecutePlayMusic().execute();
                }
            });

            playing = !playing;
        }
    }

    public static boolean isPlaying(){return playing;}


    @Override
    public void dispose() {


    }

    @Override
    public void update(float dt){
        super.update(dt);
        if (iterations%5 == 0)
            executeMoveSlider.execute();
        if (os == MAC)
            updateMusicLabels(AudioManager.getTime());
        iterations ++;
    }


    private void setUpSnapChat(){
        //TODO setup this button.
        DragButton snapChat = new DragButton(this, 250, new Image(new Texture("Friends/SwipeToDiscardButton@1.0.png")), getStage());
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
        if (gestureXRight && directionMainlyX){


            backEx.execute();
        }

    }

}
