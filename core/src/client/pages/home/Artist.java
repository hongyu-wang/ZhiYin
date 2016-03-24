package client.pages.home;

import client.events.executables.internalChanges.ExecuteToTempState;
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

    public void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000* StateManager.M);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000 * StateManager.M);

        stage.addActor(scrollpane);

        //table.setDebug(true);

        addArtist("Artist/Artist1.png", "Artist1");
        addArtist("Artist/Artist2.png", "Artist2");
        addArtist("Artist/Artist3.png", "Artist3");
        addArtist("Artist/Artist4.png", "Artist4");
        addArtist("Artist/Artist5.png", "Artist5");

    }

    public void addArtist(String picturePath, String artistName){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(artistName, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));
        Image picture = new Image(new Texture(picturePath));

        //t.add(picture).expand().left().padLeft(50 * StateManager.M);
        t.add(single).expand().left().padLeft(10 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        //TODO fix this
        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, picture, artistName));

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
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
