package client.pages.musicDiary;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public class SongSelection extends SongSelectionShell implements Gesturable{

    private ScrollPane scrollpane;
    private Table table;

    private ArrayList<SongBox> songBoxes;

    //TODO add songs to the constructor
    public SongSelection(){
        init();
    }

    @Override
    protected void init() {
        super.init();

        ExecuteChangePage backEx = new ExecuteChangePage(Pages.DIARY1, TransitionType.UP_TO_DOWN);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        addImage("Other/Discard@", backEx, 36, 63, 340, 73);

        TestExecutable sendEx = new TestExecutable("send");
        addImage("Other/Send2@", sendEx, 376, 63, 339, 73);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 200*M, 750*M, 1017*M);
        stage.addActor(scrollpane);

        songBoxes = new ArrayList<>();

        addSong(new SongBox("song1"));
        addSong(new SongBox("song2"));
        addSong(new SongBox("song3"));
        addSong(new SongBox("song4"));
        addSong(new SongBox("song5"));
        addSong(new SongBox("song6"));
        addSong(new SongBox("song7"));
        addSong(new SongBox("song8"));
        addSong(new SongBox("song9"));
        addSong(new SongBox("song10"));
        addSong(new SongBox("song11"));
        addSong(new SongBox("song12"));
        addSong(new SongBox("song13"));
        addSong(new SongBox("song14"));
        addSong(new SongBox("song15"));
        addSong(new SongBox("song16"));
    }

    private void addSong(SongBox songBox){
        disposables.add(songBox);
        songBoxes.add(songBox);
        table.add(songBox.getTable()).width(750*M).height(110*M);
        table.row();
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(!gestureYUp && !directionMainlyX)
            new ExecuteChangePage(Pages.DIARY1, TransitionType.UP_TO_DOWN).execute();
    }
}
