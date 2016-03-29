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
        scrollpane.setScrollingDisabled(true, false);

        stage.addActor(scrollpane);

        addArtist(new Image(new Texture("Artist/Artist1.png")), "Artist1");
        addArtist(new Image(new Texture("Artist/Artist2.png")), "Artist2");
        addArtist(new Image(new Texture("Artist/Artist3.png")), "Artist3");
        addArtist(new Image(new Texture("Artist/Artist4.png")), "Artist4");
        addArtist(new Image(new Texture("Artist/Artist5.png")), "Artist5");
        addArtist(new Image(new Texture("Artist/Artist1.png")), "Artist1");
        addArtist(new Image(new Texture("Artist/Artist2.png")), "Artist2");
        addArtist(new Image(new Texture("Artist/Artist3.png")), "Artist3");
        addArtist(new Image(new Texture("Artist/Artist4.png")), "Artist4");
        addArtist(new Image(new Texture("Artist/Artist5.png")), "Artist5");
    }

    public void addArtist(Image profilePic, String artistName){
        Stack right = new Stack();

        String description = "Here is a sentence that is a description of the artist and stuff and bleh and stuff and bleh and stuff and bleh and more stuff and more bleh.";
        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, profilePic, artistName, description));
        right.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        Table t1 = new Table();
        t1.add(new Image(new Texture("Home/BlackBG@" + M + ".png"))).width(600 * M).height(150*M);
        right.add(t1);

        Table t2 = new Table();
        t2.add(new Label(artistName, SkinSingleton.getInstance())).expand().center().left().padLeft(50*M);
        t2.add(new Image(new Texture("Home/Enter@" + M + ".png"))).width(16*M).height(26*M).expand().center().right().padRight(50*M);
        right.add(t2);

        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(profilePic).width(100*M).height(100*M).expand().center().padLeft(50*M);
        artistTable.add(right).width(600*M).height(150*M);

        table.add(artistTable).width(750*M).height(150*M);
        table.row();
        table.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(750*M).expandX().padLeft(50*M);
        table.row();
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
