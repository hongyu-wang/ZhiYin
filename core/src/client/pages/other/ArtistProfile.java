package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is the profile page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class ArtistProfile extends ArtistProfileShell {

    private State previousState;

    private Image profilePicture;

    private String artistName;

    private ScrollPane scrollpane;

    private Table songs;


    public ArtistProfile(State previousState, Image profilePicture, String artistName){
        this.previousState = previousState;
        this.profilePicture = profilePicture;
        this.artistName = artistName;
        init();
    }


    protected void init() {
        super.init();

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217 * StateManager.M, 117 * StateManager.M, 117 * StateManager.M);
        backButton.setExecutable(new ExecuteToTempState(previousState));
        add(backButton);

        Image i = new Image(new Texture("Other/Follow@" + StateManager.M + ".png"));
        final ImageButton followButton = new ImageButton(i.getDrawable());
        followButton.setPosition(500 * StateManager.M, 70 * StateManager.M);

        followButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("follow").execute();
            }
        });

        stage.addActor(followButton);

        Table t = new Table();
        t.setBounds(0, 900 * StateManager.M, 750 * StateManager.M, 317 * StateManager.M);
        stage.addActor(t);

        songs = new Table();
        songs.top();
        scrollpane = new ScrollPane(songs);
        scrollpane.setBounds(0, 200 * StateManager.M, 750 * StateManager.M, 700 * StateManager.M);
        stage.addActor(scrollpane);

        Label artist = new Label(artistName, SkinSingleton.getInstance());
        t.add(profilePicture).width(200 * StateManager.M).height(200 * StateManager.M).expand().left().padLeft(50 * StateManager.M);
        t.add(artist).expand().left().padLeft(50 * StateManager.M);

        //t.setDebug(true);

        addSong("Song1");
        addSong("Song2");
        addSong("Song3");
        addSong("Song4");
        addSong("Song5");
        addSong("Song6");
        addSong("Song7");
        addSong("Song8");
    }

    public void addSong(String songName){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(songName, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).expand().left().padLeft(50 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("NowPlaying").execute();
            }
        });

        songs.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        songs.row();
    }

    @Override
    public void reset() {

    }

    public void update(float dt){
        stage.act();
    }


    @Override
    public void dispose() {

    }

}
