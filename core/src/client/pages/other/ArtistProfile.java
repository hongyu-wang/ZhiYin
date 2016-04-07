package client.pages.other;

import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteSetMusic;
import client.events.executables.internalChanges.serverInteractions.ExecuteFollowArtist;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateArtistSongs;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MMusic;
import server.model.soundCloud.MBand;
import tools.utilities.Utils;

import java.util.List;

/**
 * This is the profile page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class ArtistProfile extends ArtistProfileShell implements Gesturable {
    private List<Long> musicKeys;
    public List<Long> getMusicKeys() {
        return musicKeys;
    }

    private State previousState;
    private Image profilePic;

    private ScrollPane scrollpane;
    private Table songs;

    private String artistName;
    private String description;

    private ExecuteUpdate update;
    private ExecuteFollowArtist followEx;

    public ArtistProfile(State previousState, MBand mBand, Image image){
        this.previousState = previousState;
        this.profilePic = new Image(image.getDrawable());
        this.artistName = mBand.getName();
        this.description = mBand.getDescription();
        this.musicKeys = Utils.newList();
        songs = new Table();
        this.update = new ExecuteUpdateArtistSongs(this, mBand);

        this.followEx = new ExecuteFollowArtist(this, mBand);

        init();
        //update.execute();
    }


    protected void init() {
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        addImage("Other/Follow@", followEx, 500, 70, 218, 82);

        profilePic.setBounds(50*M, 967*M, 200*M, 200*M);
        stage.addActor(profilePic);

        Table table = new Table();
        table.setBounds(300*M, 917*M, 450*M, 250*M);
        table.top();
        table.add(new Label(artistName, SkinSingleton.getInstance())).width(450*M);
        table.row();

        Label descriptionLabel = new Label(description, SkinSingleton.getInstance());
        descriptionLabel.setWrap(true);
        table.add(descriptionLabel).width(450*M).expandX().left();

        ScrollPane scrollpane = new ScrollPane(table);
        scrollpane.setBounds(300*M, 917*M, 450*M, 250*M);
        stage.addActor(scrollpane);

        songs = new Table();
        songs.top();

        scrollpane = new ScrollPane(songs);
        scrollpane.setBounds(0, 200*M, 750*M, 700*M);
        stage.addActor(scrollpane);
    }

    public void addSong(MMusic song){
        String songName = song.getName();

        Table table = new Table();
        table.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        table.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26 * M).expand().right().padRight(50 * M);
        disposables.add(tx);
        table.row();
        table.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50 * M);
        disposables.add(tx);

        Stack s = new Stack();
        s.add(new Image(tx = new Texture("Home/BlackBG@1.0.png")));
        disposables.add(tx);
        s.add(table);

        final ExecutableMultiplexer em = new ExecutableMultiplexer();

        ExecuteToTempState e = new ExecuteToTempState(new NowPlaying(this, song), TransitionType.RIGHT_TO_LEFT);
        final ExecuteSetMusic esm = new ExecuteSetMusic(song);

        em.addExecutable(e);
        em.addExecutable(esm);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                em.execute();
            }
        });

        songs.add(s).width(750*M).height(110*M);
        songs.row();
    }

    public Image getImage(){
        return profilePic;
    }

    public String getName(){
        return artistName;
    }


    public void update(float dt){
        stage.act();
    }



    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
