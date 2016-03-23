package client.pages.home;

import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
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
public class Home1 extends Home1Shell {
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
                new ExecuteChangePage(Pages.PROFILE).execute();
            }
        });

        newRelease.add(b1);

        topSingles = new Table();
        Image i2 = new Image(new Texture("Home/TopSingles@" + StateManager.M + ".png"));
        final ImageButton b2 = new ImageButton(i2.getDrawable());

        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.PROFILE).execute();
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

        table.setDebug(true);

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

//        final Texture tex = new Texture("Scrolling Test 2.png");
//
//        Image img = new Image(tex);
//        Image img3 = new Image(new Texture("PictureFiles\\tempButton1.png"));
//
//        Image img4 = new Image(new Texture("PictureFiles\\tempButton2.png"));
//        Image img5 = new Image(new Texture("PictureFiles\\tempButton3.png"));
//
//        final ScrollTable table = new ScrollTable();
//
//
//        final ImageButton button1 = new ImageButton(img3.getDrawable());
//        final ImageButton button2 = new ImageButton(img4.getDrawable());
//        final ImageButton button3 = new ImageButton(img5.getDrawable());
//
//        button1.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                new ExecuteChangeandSetMusic("Ben Rector - 30,000 Feet.mp3").execute();
//            }
//        });
//
//        button2.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                new ExecuteChangeandSetMusic("Sara Bareilles - Bottle It Up.mp3").execute();
//            }
//        });
//
//        button3.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                new ExecuteChangeandSetMusic("Avril Lavigne - Everybody Hurts.mp3").execute();
//            }
//        });
//        table.addToPane(button1);
//        table.addToPane(button2);
//        table.addToPane(button3);
//        table.addToPane(img);
//
//
//
//        stage.addActor(table.getPane());
    }

    public void addNewRelease(String artistName, String songName){
        newRelease.row().padTop(30 * StateManager.M);
        newRelease.add(createNewSingle(artistName, songName)).expand();
    }

    public void addTopSingle(String artistName, String songName) {
        topSingles.row().padTop(30 * StateManager.M);
        topSingles.add(createNewSingle(artistName, songName));
    }

    private Table createNewSingle(String artistName, String songName){
        Table t = new Table();

        Label artist = new Label(artistName, SkinSingleton.getInstance());
        Label song = new Label(songName, SkinSingleton.getInstance());
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(artist);
        t.row();
        t.add(song);
        t.row().padTop(28 * StateManager.M);
        t.add(line);

        t.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.NOWPLAYING).execute();
            }
        });

        return t;
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
