package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is the first music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary1 extends Diary1Shell {

    private ScrollPane scrollpane;

    private Table table;

    public Diary1(){
        init();
    }

    protected void init() {
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100* StateManager.M);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);

        stage.addActor(scrollpane);

        addPost("Person1", "Title1", "TimeStamp1");
        addPost("Person2", "Title2", "TimeStamp2");
        addPost("Person3", "Title3", "TimeStamp3");
        addPost("Person4", "Title4", "TimeStamp4");
        addPost("Person5", "Title5", "TimeStamp5");
        addPost("Person6", "Title6", "TimeStamp6");
        addPost("Person7", "Title7", "TimeStamp7");
        addPost("Person8", "Title8", "TimeStamp8");
        addPost("Person9", "Title9", "TimeStamp9");
        addPost("Person10", "Title10", "TimeStamp10");
        addPost("Person11", "Title11", "TimeStamp11");
        addPost("Person12", "Title12", "TimeStamp12");
    }

    public void addPost(String name, String timestamp, String title){
        Stack s = new Stack();

        Table t = new Table();

        Label l1 = new Label(name, SkinSingleton.getInstance());
        Label l2 = new Label(title, SkinSingleton.getInstance());
        Label l3 = new Label(timestamp, SkinSingleton.getInstance());

        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(l1).expand().left().padLeft(50 * StateManager.M);
        t.add(l2).expand().right().padRight(50 * StateManager.M);
        t.row().padTop(10 * StateManager.M);
        t.add(l3).expand().left().padLeft(50 * StateManager.M);
        t.row();
        t.add(line).padTop(40 * StateManager.M);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        // Goes to a Diary4 without content or image
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteToTempState(new Diary4("title", "", null)).execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }


}
