package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import server.model.media.MMusic;
import tools.serverTools.databases.LocalDatabaseFactory;

import java.util.ArrayList;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public class SongSelection extends SongSelectionShell implements Gesturable{

    private Diary2 diary2;

    private ScrollPane scrollpane;
    private Table table;

    private ArrayList<SongBox> songBoxes;
    private SongBox selected;

    //TODO add songs to the constructor
    public SongSelection(Diary2 diary2){
        this.diary2 = diary2;
        init();
    }

    @Override
    protected void init() {
        super.init();

//        ExecuteChangePage backEx = new ExecuteChangePage(Pages.DIARY2, TransitionType.LEFT_TO_RIGHT);
//        addImage("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

//        ExecuteChangePage sendEx = new ExecuteChangePage(Pages.DIARY2, TransitionType.LEFT_TO_RIGHT);
//        Table send = createImage("Diary/Share@", sendEx, 35, 64, 680, 72);
//        send.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                if(diary2.hasSongBox()) {
//                    diary2.setSongBox(selected);
//                    sendEx.execute();
//                }
//            }
//        });
//        stage.addActor(send);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 0, 750 * M, 1334 * M);
        stage.addActor(scrollpane);

        songBoxes = new ArrayList<>();

        if (os == MAC) {
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10000L)));
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10001L)));
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10002L)));
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10003L)));
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10004L)));
            addSong(new SongBox(this, LocalDatabaseFactory.createLocalDatabase().<MMusic>getModel(10005L)));
        }
    }

    public void addSong(SongBox songBox){
        disposables.add(songBox);
        songBoxes.add(songBox);
        table.add(songBox.getTable()).width(750*M).height(110*M);
        table.row();
    }

    public void passBox(SongBox box){
        diary2.setSongBox(box);
    }

//
//    public void reset(){
//        for(SongBox box : songBoxes){
//            box.deselect();
//        }
//    }
//
//    public void setSelected(SongBox box){
//        selected = box;
//    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.DIARY2, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
