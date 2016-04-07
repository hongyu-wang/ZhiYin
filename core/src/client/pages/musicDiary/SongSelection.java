package client.pages.musicDiary;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public class SongSelection extends SongSelectionShell {

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

        ExecuteChangePage backEx = new ExecuteChangePage(Pages.DIARY1);
        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        addImage("Other/Discard@", backEx, 36, 63, 340, 73);

        TestExecutable sendEx = new TestExecutable("send");
        addImage("Other/Send@", backEx, 376, 63, 339, 73);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 200*M, 750*M, 1017*M);
        stage.addActor(scrollpane);

        songBoxes = new ArrayList<>();

        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
        addSong(new SongBox("song"));
    }

    private void addSong(SongBox songBox){
        songBoxes.add(songBox);
        table.add(songBox.getTable()).width(750*M).height(110*M);
    }

    @Override
    public void dispose() {

    }
}
