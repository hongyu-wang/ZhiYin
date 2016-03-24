package client.pages.home;

import client.events.executables.internalChanges.ExecuteChangePage;
import client.events.executables.internalChanges.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home extends HomeShell {
    private ScrollPane scrollpane;
    private Table table;
    private Table newRelease;
    private Table topSingles;

    public void init() {
        super.init();

        newRelease = new Table();
        Image i1 = new Image(new Texture("Home/NewRelease@" + StateManager.M + ".png"));
        final ImageButton b1 = new ImageButton(i1.getDrawable());

        b1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.TOPSINGLES).execute();
            }
        });

        newRelease.add(b1);

        topSingles = new Table();
        Image i2 = new Image(new Texture("Home/TopSingles@" + StateManager.M + ".png"));
        final ImageButton b2 = new ImageButton(i2.getDrawable());

        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.TOPSINGLES).execute();
            }
        });

        topSingles.add(b2);


        table = new Table();
        table.add(newRelease);
        table.row().padTop(30 * StateManager.M);
        table.add(topSingles);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);

        stage.addActor(scrollpane);

        //table.setDebug(true);

        addNewRelease("artist1", "song1");
        addNewRelease("artist2", "song2");
        addNewRelease("artist3", "song3");
        addNewRelease("artist4", "song4");
        addNewRelease("artist1", "song1");
        addNewRelease("artist2", "song2");
        addNewRelease("artist3", "song3");
        addNewRelease("artist4", "song4");

        addTopSingle("artist5", "song5");
        addTopSingle("artist6", "song6");
        addTopSingle("artist7", "song7");
        addTopSingle("artist8", "song8");
        addTopSingle("artist5", "song5");
        addTopSingle("artist6", "song6");
        addTopSingle("artist7", "song7");
        addTopSingle("artist8", "song8");
    }

    public void addNewRelease(String artistName, String songName){
        newRelease.row().padTop(30 * StateManager.M);
        newRelease.add(createNewSingle(artistName, songName)).width(750 * StateManager.M);
    }

    public void addTopSingle(String artistName, String songName) {
        topSingles.row().padTop(30 * StateManager.M);
        topSingles.add(createNewSingle(artistName, songName)).width(750 * StateManager.M);
    }

    private Stack createNewSingle(String artistName, String songName){
        Stack s = new Stack();

        Table t = new Table();

        Label label = new Label(artistName + "\n" + songName, SkinSingleton.getInstance());
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        //ImageButton button = new ImageButton(i.getDrawable());

        t.add(label).expand().left().padLeft(50 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line).padTop(28 * StateManager.M);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new NowPlaying(this));

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        return s;
    }


    @Override
    public void dispose() {

    }



    @Override
    public void draw(){
        super.draw();

    }

    @Override
    public void reset() {

    }

}
