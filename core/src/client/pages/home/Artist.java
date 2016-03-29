package client.pages.home;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.other.ArtistProfile;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static client.singletons.StateManager.M;

/**
 * This is the third home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Artist extends ArtistShell {
    private TextField searchField;

    private ScrollPane scrollpane;

    private Table table;

    private Image image;

    public Artist(){
        init();
    }

    public Artist(Image image){
        this.image = image;
        init();
    }

    protected void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000* StateManager.M);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000 * StateManager.M);

        stage.addActor(scrollpane);

        //table.setDebug(true);

        addArtist(new Image(new Texture("Artist/Artist1.png")), "Artist1");
        addArtist(new Image(new Texture("Artist/Artist2.png")), "Artist2");
        addArtist(new Image(new Texture("Artist/Artist3.png")), "Artist3");
        addArtist(new Image(new Texture("Artist/Artist4.png")), "Artist4");
        addArtist(new Image(new Texture("Artist/Artist5.png")), "Artist5");
    }

    public void addArtist(Image profilePic, String artistName){
        // Create picTable
        Table picTable = new Table();
        table.add(picTable).width(50*M).height(150*M);
        picTable.add(profilePic).width(50*M).height(50*M).expandY().padTop(50*M);

        // Create stack rest
        Stack rest = new Stack();
        rest.setSize(650*M, 150*M);

        // Add BlackBG to rest
        Table restTable1 = new Table();
        restTable1.add(new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png")));
        rest.add(restTable1);

        // Add table with artist name and enter picture to rest
        Table restTable2 = new Table();
        Label artistLabel = new Label(artistName, SkinSingleton.getInstance());
        Image enter = new Image(new Texture("Home/Enter@" + M + ".png"));
        restTable2.add(artistLabel).expandX().left().padLeft(10*M).padTop(50*M);
        restTable2.add(enter).width(16*M).height(26*M).expandX().right().padRight(50*M).padTop(50*M);
        rest.add(restTable2);

        // Add picTable and rest to artistTable
        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(picTable).width(50*M).height(150 * M);
        artistTable.add(rest).width(650*M).height(150*M);
        artistTable.row();
        artistTable.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(700*M).expandX().padLeft(50*M).padTop(50*M);

        // Add click functionality for artistTable
        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, profilePic, artistName));
        artistTable.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        // Add artistTable to table
        table.add(artistTable).width(700*M).height(200*M);


//        Stack s = new Stack();
//
//        Table t = new Table();
//        t.top();
//
//        Label single = new Label(artistName, SkinSingleton.getInstance());
//        Image enter = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
//        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));
//
//        t.add(profilePic);//.width(50 * StateManager.M).height(50 * StateManager.M);//expandX().left().padLeft(50 * StateManager.M).padTop(50 * StateManager.M);
////        t.add(single).expandX().left().padLeft(10 * StateManager.M).padTop(50 * StateManager.M);
////        t.add(enter).width(16 * StateManager.M).height(26 * StateManager.M).expandX().right().padRight(50 * StateManager.M).padTop(50 * StateManager.M);
////        t.row();
////        t.add(line).width(700 * StateManager.M).expandX().padLeft(50 * StateManager.M).padTop(50 * StateManager.M);
//
//        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));
//        i2.setSize(750 * StateManager.M, 300 * StateManager.M);
//
//        //s.add(i2);
//        s.add(t);
//        //t.setSize(750 * StateManager.M, 300 * StateManager.M);
//
//        //TODO fix this
//        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, profilePic, artistName));
//
//        s.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                e.execute();
//            }
//        });
//
//        table.add(s).width(750 * StateManager.M).height(300 * StateManager.M);
//        table.row();
    }

    @Override
    public void reset() {
        searchField.remove();
        addSearchField();
    }

    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition((26 + 1) * M, 1146 * M);
        searchField.setSize(642 * M, 58 * M);

        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }


    @Override
    public void dispose() {

    }

}
