package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import server.model.media.MMusic;

import java.util.ArrayList;
import java.util.List;

import static client.tools.Constants.M;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public class SongBox implements Disposable {
    private Texture tx1 = new Texture("Diary/Unselected@1.0.png");
    private Texture tx2 = new Texture("Diary/Selected@1.0.png");
    private List<Disposable> disposableList;
    private Image image0 = new Image(tx1);
    private Image image1 = new Image(tx2);

    private SongSelection songSelect;
    private Table table;
    private MMusic music;

    public MMusic getMusic() {
        return music;
    }

    public void setMusic(MMusic music) {
        this.music = music;
    }

    private String songName;
    private Image image;

    public SongBox(SongSelection songSelect, MMusic song){
        this.songSelect = songSelect;
        this.songName = song.getName();
        this.music = song;
        disposableList = new ArrayList<>();
        disposableList.add(tx1);
        disposableList.add(tx2);
        init();
    }

    private void init(){
        table = new Table();
        image = new Image(new Texture("Diary/Unselected@1.0.png"));
//        select();
        initTable();
    }

    private void initTable(){
        Table t = new Table();
        t.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50 * M);
        t.add(image).width(40*M).height(40*M).expand().right().padRight(50 * M);
        t.row();
        t.add(new Image(tx1 = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50*M);
        disposableList.add(tx1);

        Stack s = new Stack();
        s.add(new Image(tx1 = new Texture("Home/BlackBG@1.0.png")));
        disposableList.add(tx1);
        s.add(t);

        SongBox box = this;
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                songSelect.passBox(box);
                new ExecuteChangePage(Pages.DIARY2, TransitionType.LEFT_TO_RIGHT).execute();
            }
        });

        table.add(s).width(750*M).height(110*M);
        table.row();
    }

//    public void select(){
//        if(!selected) {
//            songSelect.reset();
//            songSelect.setSelected(this);
//        }
//        selected = !selected;
//        image.setDrawable((selected ? image1 : image0).getDrawable());
//    }
//
//    public void deselect(){
//        selected = false;
//        image.setDrawable(image0.getDrawable());
//    }
//
//    public boolean isSelected(){
//        return selected;
//    }

    public Table getTable(){
        return table;
    }

    @Override
    public void dispose() {
        for (Disposable ds : disposableList){
            ds.dispose();
        }
    }
}
