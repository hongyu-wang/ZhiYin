package client.pages.other;

import client.events.executables.internalChanges.serverInteractions.ExecuteFollowArtist;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateArtistSongs;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
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
public class ArtistProfile extends ArtistProfileShell {
    private List<Long> musicKeys;

    public List<Long> getMusicKeys() {
        return musicKeys;
    }

    private State previousState;

    private Image profilePic;

    private String artistName;
    private String description;

    private ScrollPane scrollpane;

    private Table songs;

    private ExecuteUpdate update;
    private ExecuteFollowArtist followEx;

    public ArtistProfile(State previousState, MBand mBand, Image image){
        this.previousState = previousState;
        this.profilePic = new Image(image.getDrawable());
        this.artistName = mBand.getName();
        this.description = mBand.getDescription();
        this.musicKeys = Utils.newList();

        this.update = new ExecuteUpdateArtistSongs(this, mBand);
        this.followEx = new ExecuteFollowArtist(this, mBand);

        init();
    }


    protected void init() {
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        addImageButton("Other/Follow@", followEx, 500, 70, 218, 82);


//        Table table = new Table();
//        table.setBounds(0, 900*M, 750*M, 317*M);

//        Table left = new Table();
//        left.top();
//        left.add(profilePic).width(200*M).height(200*M).expand().center();
//        table.add(left).width(300 * M).height(300 * M);

        profilePic.setBounds(50*M, 967*M, 200*M, 200*M);
        stage.addActor(profilePic);

        Table table = new Table();
        table.setBounds(300*M, 917*M, 450*M, 300*M);
        table.top();
        table.add(new Label(artistName, SkinSingleton.getInstance())).width(450*M);
        table.row();

        Label descriptionLabel = new Label(description, SkinSingleton.getInstance());
        descriptionLabel.setWrap(true);
//        descriptionLabel.setWidth(400*M);
        table.add(descriptionLabel).width(450*M).expandX().left();

        ScrollPane scrollpane = new ScrollPane(table);
        scrollpane.setBounds(300*M, 917*M, 450 * M, 300 *M);
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
        table.add(new Image(new Texture("Home/Enter@" + M + ".png"))).width(16*M).height(26*M).expand().right().padRight(50*M);
        table.row();
        table.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(750 * M).expandX().padLeft(50*M);

        Stack s = new Stack();
        s.add(new Image(new Texture("Home/BlackBG@" + M + ".png")));
        s.add(table);

        final ExecuteToTempState ex = new ExecuteToTempState(new NowPlaying(this, song));
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ex.execute();
            }
        });

        songs.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
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
    public void dispose() {

    }

}
