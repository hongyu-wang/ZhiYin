package client.pages.home;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static client.singletons.StateManager.M;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Tagged extends TaggedShell {

    private String tag;

    private ScrollPane scrollpane;

    private Table songs;

    private State previousState;

    public Tagged(State previousState, String tag){
        this.previousState = previousState;
        this.tag = tag;
        init();
    }

    protected void init(){
        super.init();

        Table topTable = new Table();
        topTable.setBounds(0 * StateManager.M, 1217 * StateManager.M, 750 * StateManager.M, 117 * StateManager.M);
        stage.addActor(topTable);

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        ImageButton backButton = createImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);
        topTable.add(backButton).width(117).height(117);

        Label tagLabel = new Label(tag, SkinSingleton.getInstance());
        Table t = new Table();
        t.add(tagLabel).expand().center().padRight(117 * StateManager.M);
        topTable.add(t).width(633 * StateManager.M).height(117 * StateManager.M);

        songs = new Table();
        songs.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
        songs.top();

        scrollpane = new ScrollPane(songs);
        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
        stage.addActor(scrollpane);

        scrollpane.setScrollingDisabled(true, false);

        addSong("Song1");
        addSong("Song2");
        addSong("Song3");
        addSong("Song4");
        addSong("Song5");
        addSong("Song6");
        addSong("Song7");
        addSong("Song8");
    }

    public void addSong(String songName){
        Table table = new Table();
        table.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50 * M);
        table.add(new Image(new Texture("Home/Enter@" + M + ".png"))).width(16*M).height(26*M).expand().right().padRight(50 * M);
        table.row();
        table.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(750 * M).expandX().padLeft(50*M);

        Stack s = new Stack();
        s.add(new Image(new Texture("Home/BlackBG@" + M + ".png")));
        s.add(table);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("NowPlaying").execute();
            }
        });

        songs.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        songs.row();
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
