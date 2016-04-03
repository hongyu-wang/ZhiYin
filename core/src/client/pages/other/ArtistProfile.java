package client.pages.other;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.soundCloud.MBand;

import static client.singletons.StateManager.M;

/**
 * This is the profile page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class ArtistProfile extends ArtistProfileShell {

    private State previousState;

    private Image profilePic;

    private String artistName;
    private String description;

    private ScrollPane scrollpane;

    private Table songs;


    public ArtistProfile(State previousState, MBand mBand, Image image){
        this.previousState = previousState;
        this.profilePic = image;
        this.artistName = mBand.getName();
        this.description = mBand.getDescription();
        init();
    }


    protected void init() {
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        TestExecutable followEx = new TestExecutable("follow");
        addImageButton("Other/Follow@",followEx, 500, 70, 218, 82);


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
        descriptionLabel.setWidth(400*M);
        table.add(descriptionLabel).width(450*M).expandX().left();

        stage.addActor(table);

        songs = new Table();
        songs.top();

        scrollpane = new ScrollPane(songs);
        scrollpane.setBounds(0, 200*M, 750*M, 700*M);
        stage.addActor(scrollpane);

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
        Table table = new Table();
        table.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        table.add(new Image(new Texture("Home/Enter@" + M + ".png"))).width(16*M).height(26*M).expand().right().padRight(50*M);
        table.row();
        table.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(750 * M).expandX().padLeft(50*M);

        Stack s = new Stack();
        s.add(new Image(new Texture("Home/BlackBG@" + M + ".png")));
        s.add(table);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("NowPlaying").execute();
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
