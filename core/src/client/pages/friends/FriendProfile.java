package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateProfileArtists;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateProfileDiary;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.musicDiary.Diary4;
import client.pages.other.ArtistProfile;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Gesturable;
import client.stateInterfaces.Profile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MBand;
import tools.utilities.Utils;

import java.util.List;

/**
 *
 * Created by blobbydude24 on 2016-03-21.
 */
public class FriendProfile extends FriendProfileShell implements Profile, Gesturable {
    private List<Long> currentDiaries;
    private List<Long> currentArtists;

    @Override
    public List<Long> getCurrentArtists() {
        return currentArtists;
    }

    @Override
    public List<Long> getCurrentDiaries() {
        return currentDiaries;
    }


    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;
    private String description;

    private Image image;

    private ExecuteUpdate update1;
    private ExecuteUpdate update2;

    public FriendProfile(State previousState, String name){
        this.previousState = previousState;
        this.name = name;
        init();
    }

    public FriendProfile(State previousState, String name, Image image){
        this.previousState = previousState;

        //TODO replace these values with values from server
        this.name = name;
        this.image = image;
        this.description = "here is a really long description that I am typing just to test wrapping of the words, as well as scrollpane vertical scrolling;" +
                "more redundant words are being typed right now and stuff and stuff and stuff and more stuff and more stuff and more stuff and more stuff";

        currentDiaries = Utils.newList();
        currentArtists = Utils.newList();
        init();
    }

    protected void init(){
        super.init();

        //----ServerUpdates-------//

        this.update1 = new ExecuteUpdateProfileArtists(this, name);
        this.update2 = new ExecuteUpdateProfileDiary(this, name);

        //----ServerUpdates-------//

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT));
        add(backButton);

        ExecuteToTempState e = new ExecuteToTempState(new Friends2(this, name));
        addImage("Friends/Chat@", e, 300, 950, 50, 50);

        Table t = new Table();
        t.setBounds(300*M, 1000*M, 450*M, 167*M);
        t.top();
        t.add(new Label(name, SkinSingleton.getInstance())).width(450*M);
        t.row();

        Label descriptionLabel = new Label(description, SkinSingleton.getInstance());
        descriptionLabel.setWrap(true);
        t.add(descriptionLabel).width(450*M).expandX().left();

        ScrollPane s = new ScrollPane(t);
        s.setBounds(300*M, 1000*M, 450*M, 167*M);
        stage.addActor(s);

        if(image != null) {
            image.setBounds(50*M, 967*M, 200*M, 200*M);
            stage.addActor(image);
        }

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0,  570*M, 750*M, 250*M);
        stage.addActor(scrollpane);

        following = new Table();
        following.top();

        scrollpane2 = new ScrollPane(following);
        scrollpane2.setBounds(50*M,  350*M, 700*M, 150*M);
        stage.addActor(scrollpane2);

    }

    @Override
    public void addPost(final MDiaryPost diaryPost){
        String title = diaryPost.getTitle();

        Table t = new Table();
        t.add(new Label(title, SkinSingleton.getInstance())).expand().left().padLeft(50 * M);
        t.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26*M).expand().right().padRight(50 * M);
        disposables.add(tx);
        t.row();
        t.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750 * M).height(4*M).expandX().padLeft(50*M);
        disposables.add(tx);

        Stack s = new Stack();
        s.add(new Image(tx = new Texture("Home/BlackBG@1.0.png")));
        disposables.add(tx);
        s.add(t);



        final ExecuteToTempState e = new ExecuteToTempState(new Diary4(this, diaryPost, null), this);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750*M).height(110 * M);
        table.row();
    }

    public void addFollowing(MBand artist, Image image){
        ImageButton artistButton = new ImageButton(image.getDrawable());
        final Executable ex = new ExecuteToTempState(new ArtistProfile(this, artist, image), this);
        artistButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ex.execute();
            }
        });

        following.add(artistButton).width(150*M).height(150*M).padRight(50 * M);
    }



    @Override
    public void update(float dt) {
        super.update(dt);
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.FRIENDS4, TransitionType.LEFT_TO_RIGHT).execute();
    }
}