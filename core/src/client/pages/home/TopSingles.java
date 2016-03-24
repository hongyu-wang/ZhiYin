package client.pages.home;

import client.events.executables.internalChanges.ExecuteToTempState;
import client.pages.other.NowPlaying;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by blobbydude24 on 2016-03-23.
 */
public class TopSingles extends TopSinglesShell {

    private Table table;

    public void init() {
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
        table.top();

        //table.setDebug(true);

        Music music = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Hand towel.mp3"));
        addSingle("Hand towel", music);
        Music music1 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Blind spot.mp3"));
        addSingle("Blind spot", music1);
        Music music2 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Brave Shine.mp3"));
        addSingle("Brave Shine", music2);
        Music music3 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Be Ok.mp3"));
        addSingle("Be Ok", music3);
        Music music4 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Imagine Dragons - Monster.mp3"));
        addSingle("Imagine Dragons - Monster", music4);
        Music music5 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Jasmine Thompson - See You Again.mp3"));
        addSingle("Jasmine Thompson - See You Again", music5);
        Music music6 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Katy Perry - Hot N Cold.mp3"));
        addSingle("Hot N Cold", music6);
        Music music7 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Katy Perry - I Kissed a Girl.mp3"));
        addSingle("Katy Perry - I Kissed a Girl", music7);
        Music music8 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/OneRepublic - Counting Stars.mp3"));
        addSingle("OneRepublic - Counting Stars", music8);
        Music music9 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/P!NK - Just Give Me a Reason.mp3"));
        addSingle("P!NK - Just Give Me a Reason", music9);
        Music music10 = Gdx.audio.newMusic(Gdx.files.internal("../Music Assets/Road of wind.mp3"));
        addSingle("Road of wind", music10);

        stage.addActor(table);
    }


    public void addSingle(String songName, Music music) {
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

        //TODO ExecuteToTempState stuff
        final ExecuteToTempState e = new ExecuteToTempState(new NowPlaying(this, music));

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

    }
}
