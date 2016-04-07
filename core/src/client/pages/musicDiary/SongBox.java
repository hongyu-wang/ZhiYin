package client.pages.musicDiary;

import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import static client.tools.Constants.M;

/**
 * Created by blobbydude24 on 2016-04-06.
 */
public class SongBox {

    private static Image image0 = new Image(new Texture("Diary/Unselected@1.0.png"));
    private static Image image1 = new Image(new Texture("Diary/Selected@1.0.png"));

    private Table table;

    private String songName;
    private Image image;
    private boolean selected;

    public SongBox(String songName){
        this.songName = songName;
        init();
    }

    private void init(){
        table = new Table();
        image = new Image();
        selected = true;
        select();
        initTable();
    }

    private void initTable(){
        Table t = new Table();
        t.add(new Label(songName, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        t.add(image).width(40*M).height(40*M).expand().right().padRight(50*M);
        t.row();
        t.add(new Image(new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50*M);

        Stack s = new Stack();
        s.add(new Image(new Texture("Home/BlackBG@1.0.png")));
        s.add(t);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                select();
            }
        });

        table.add(s).width(750*M).height(110*M);
        table.row();
    }

    public void select(){
        selected = !selected;
        image.setDrawable((selected ? image1 : image0).getDrawable());
    }

    public boolean isSelected(){
        return selected;
    }

    public Table getTable(){
        return table;
    }

}
