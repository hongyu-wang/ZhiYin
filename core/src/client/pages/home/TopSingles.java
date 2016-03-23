package client.pages.home;

import client.events.executables.internalChanges.ExecuteToTempState;
import client.pages.other.NowPlaying;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
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
public class TopSingles extends TopSinglesShell{

    private Table table;

    public void init(){
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100* StateManager.M);
        table.top();

        //table.setDebug(true);

        addSingle("Song1");
        addSingle("Song2");
        addSingle("Song3");
        addSingle("Song4");
        addSingle("Song5");
        addSingle("Song6");
        addSingle("Song7");
        addSingle("Song8");
        addSingle("Song9");
        addSingle("Song10");

        stage.addActor(table);
    }


    public void addSingle(String songName){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(songName, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));

        t.add(single).expand().left().padLeft(50 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);

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

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();

    }

    @Override
    public void reset() {

    }
}