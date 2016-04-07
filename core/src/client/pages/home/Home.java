package client.pages.home;

import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteSetMusic;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.NowPlaying;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MMusic;
import server.model.structureModels.ServerModel;
import tools.AudioTools.AudioCreator;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;


/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home extends HomeShell implements Gesturable{
    private ScrollPane scrollpane;
    private Table table;
    private Table newRelease;
    private Table topSingles;

    public Home(){
        init();
    }

    private MMusic generateTestMMusic(){
        MMusic temporary = new MMusic();
        temporary.setKey(-420L);
        temporary.setAlbumArt(8000L);
        temporary.setName("Test");
        temporary.setComments(Utils.newList());

        List<ServerModel> pushList = Utils.newList();
        pushList.add(temporary);
        LocalDatabaseFactory.createLocalDatabase().pushModel(pushList);

        return temporary;
    }

    protected void init() {
        super.init();

        newRelease = new Table();
        Image i1 = new Image(tx = new Texture("Home/NewRelease@1.0.png"));
        disposables.add(tx);

        final ImageButton b1 = new ImageButton(i1.getDrawable());

        if (os == WINDOWS) {
            MMusic temporary = generateTestMMusic();
            final State tempState = new NowPlaying(this, temporary);
            b1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    new ExecuteToTempState(tempState, TransitionType.RIGHT_TO_LEFT).execute();
                }
            });
        }

        newRelease.add(b1).width(750*M).height(92*M);

        topSingles = new Table();
        Image i2 = new Image(tx = new Texture("Home/TopSingles@1.0.png"));
        disposables.add(tx);
        final ImageButton b2 = new ImageButton(i2.getDrawable());

        b2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.TOPSINGLES, TransitionType.RIGHT_TO_LEFT).execute();
            }
        });

        topSingles.add(b2).width(750*M).height(92*M);

        table = new Table();
        table.add(newRelease);
        table.row().padTop(30*M);
        table.add(topSingles);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117*M, 750*M, 1100*M);

        stage.addActor(scrollpane);
        if (os == MAC)
            initMusic();
    }

    private void initMusic(){
        int i = 0;
        Map<String, MMusic> map = AudioCreator.songNameToMMusic;

        boolean isTopSingle = false;
        for (String str : map.keySet()){
            MMusic temporary = map.get(str);

            if (isTopSingle)
                addTopSingle(temporary.getArtist(), temporary.getName(), temporary);

            else
                addNewRelease(temporary.getArtist(), temporary.getName(), temporary);

            if (i == 2){
                isTopSingle = true;
            }
            i++;
            if (i >= 6){
                break;
            }
        }
    }

    public void addNewRelease(String artistName, String songName, MMusic music){
        newRelease.row().padTop(30*M);
        newRelease.add(createNewSingle(artistName, songName, music)).width(750*M);
    }

    public void addTopSingle(String artistName, String songName, MMusic music) {
        topSingles.row().padTop(30*M);
        topSingles.add(createNewSingle(artistName, songName, music)).width(750*M);
    }

    private Stack createNewSingle(String artistName, String songName, MMusic music){
        Stack s = new Stack();

        Table t = new Table();

        Label label = new Label(artistName + "\n" + songName, SkinSingleton.getInstance());
        Image line = new Image(tx = new Texture("Home/Line@1.0.png"));
        disposables.add(tx);

        Image i = new Image(tx = new Texture("Home/Enter@1.0.png"));
        disposables.add(tx);

        t.add(label).expand().left().padLeft(50*M);
        t.add(i).expand().right().padRight(50*M);
        t.row();
        t.add(line).padTop(28*M);

        Image i2 = new Image(tx = new Texture("Home/BlackBG@1.0.png"));
        disposables.add(tx);

        s.add(i2);
        s.add(t);

        final ExecutableMultiplexer em = new ExecutableMultiplexer();

        ExecuteToTempState e = new ExecuteToTempState(new NowPlaying(this, music), TransitionType.RIGHT_TO_LEFT);
        final ExecuteSetMusic esm = new ExecuteSetMusic(music);

        em.addExecutable(e);
        em.addExecutable(esm);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                em.execute();
            }
        });

        return s;
    }


    @Override
    public void draw(){
        super.draw();

    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(!gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.ARTIST, TransitionType.RIGHT_TO_LEFT).execute();
    }
}
