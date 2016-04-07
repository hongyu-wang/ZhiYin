package client.pages.musicDiary;

import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateAllDiaries;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.social.MDiaryPost;
import tools.utilities.Utils;

import java.util.List;

/**
 * This is the first music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary1 extends Diary1Shell{
    private List<Long> currentDiaries;
    public List<Long> getCurrentDiaries(){
        return currentDiaries;
    }

    private ScrollPane scrollpane;
    private Table table;

    private ExecuteUpdate update;

    public Diary1(){
        init();
    }

    protected void init() {
        super.init();

        table = new Table();
        table.setBounds(0, 117*M, 750*M, 1100*M);
        table.top();

        currentDiaries = Utils.newList();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117*M, 750*M, 1100*M);

        stage.addActor(scrollpane);

        //Updates from server.
        this.update = new ExecuteUpdateAllDiaries(this);
    }

    public void addPost(MDiaryPost thisPost, String creator, String timestamp){
        String title = thisPost.getTitle();

        String name = creator;

        Stack s = new Stack();

        Table t = new Table();

        Label l1 = new Label(name, SkinSingleton.getInstance());
        Label l2 = new Label(timestamp, SkinSingleton.getInstance());
        Label l3 = new Label(title, SkinSingleton.getInstance());

        t.add(l1).expand().left().padLeft(50*M).padTop(50*M);
        t.add(l2).expand().right().padRight(50 * M).padTop(50*M);
        t.row().padTop(10*M);
        t.add(l3).expand().left().padLeft(50 * M);
        t.row();
        t.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(150*M).padTop(50*M);
        disposables.add(tx);

        Image i2 = new Image(tx = new Texture("Home/BlackBG@1.0.png"));
        disposables.add(tx);

        s.add(i2);
        s.add(t);

        final MDiaryPost currentPost = thisPost;

        final ExecuteToTempState e = new ExecuteToTempState(new Diary4(this, currentPost, null), TransitionType.RIGHT_TO_LEFT);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750*M);
        table.row();
    }

    @Override
    public void update(float dt){
        super.update(dt);
    }
}
