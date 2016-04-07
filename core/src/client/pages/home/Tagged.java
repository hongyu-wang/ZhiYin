package client.pages.home;

import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateHashtagSongs;
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

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Tagged extends TaggedShell implements Gesturable{
    private State previousState;
    private ScrollPane scrollpane;
    private Table songs;

    private String tag;

    private ExecuteUpdate update;

    public Tagged(State previousState, String tag){
        this.previousState = previousState;
        this.tag = tag;

        //Required for server updating.
        this.update = new ExecuteUpdateHashtagSongs(this, tag);

        init();
    }

    protected void init(){
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState, TransitionType.LEFT_TO_RIGHT);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Table t = new Table();
        t.setBounds(117*M, 1217*M, 516*M, 117*M);
        t.add(new Label(tag, SkinSingleton.getInstance())).expand().center();
        stage.addActor(t);

        songs = new Table();
        songs.setBounds(0, 117*M, 750*M, 1100*M);
        songs.top();

        scrollpane = new ScrollPane(songs);
        scrollpane.setBounds(0, 117*M, 750*M, 1100*M);
        stage.addActor(scrollpane);

        scrollpane.setScrollingDisabled(true, false);
    }

    public void addSong(MMusic music){
        String songName = music.getName();

        Table table = new Table();
        table.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        table.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26 * M).expand().right().padRight(50 * M);
        disposables.add(tx);
        table.row();
        table.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50 * M);
        disposables.add(tx);

        Stack s = new Stack();
        Table t = new Table();
        t.add(new Image(tx = new Texture("Home/BlackBG@1.0.png"))).width(700*M).height(110*M);
        disposables.add(tx);
        s.add(t);
        s.add(table);

        final ExecuteToTempState ex = new ExecuteToTempState(new NowPlaying(this, music), this );
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ex.execute();
            }
        });

        songs.add(s).width(750*M).height(110*M);
        songs.row();
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.DISCOVERY, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
