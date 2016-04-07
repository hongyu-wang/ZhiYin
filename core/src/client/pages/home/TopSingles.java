package client.pages.home;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.NowPlaying;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MMusic;
import tools.AudioTools.AudioCreator;

/**
 *
 * Created by blobbydude24 on 2016-03-23.
 */
public class TopSingles extends TopSinglesShell implements Gesturable{
    private Table table;

    public TopSingles(){
        init();
    }

    protected void init(){
        super.init();

        table = new Table();
        table.setBounds(0, 117*M, 750*M, 1100*M);
        table.top();

        //table.setDebug(true);
        if (os == MAC)
            addSingles();

        stage.addActor(table);
    }

    private void addSingles(){
        int i = 0;

        for (String name : AudioCreator.songNameToMMusic.keySet()){

            addSingle(name, AudioCreator.songNameToMMusic.get(name));

            if (i >= 10) break;
            i++;
        }
    }

    public void addSingle(String songName, MMusic music){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(songName, SkinSingleton.getInstance());
        Image i = new Image(tx = new Texture("Home/Enter@1.0.png"));
        disposables.add(tx);
        Image line = new Image(tx = new Texture("Home/Line@1.0.png"));
        disposables.add(tx);
        line.setSize(750 * M, 4*M);

        t.add(single).expand().left().padLeft(50*M);
        t.add(i).width(16 * M).height(26 * M).expand().right().padRight(50*M);
        t.row();
        t.add(line).width(750*M).height(4*M).expandX().padLeft(50 * M);

        Image i2 = new Image(tx = new Texture("Home/BlackBG@1.0.png"));
        disposables.add(tx);

        s.add(i2);
        s.add(t);

        //TODO ExecuteToTempState stuff
        final ExecuteToTempState e = new ExecuteToTempState(new NowPlaying(this, music), this);
//        final TestExecutable e = new TestExecutable("now playing");

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750*M).height(110*M);
        table.row();
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.HOME, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
