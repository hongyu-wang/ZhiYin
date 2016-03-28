package client.pages.friends;


import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Friends4 extends Friends4Shell{
    private ScrollPane scrollpane;

    private Table table;

    public void init(){
        super.init();

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
        stage.addActor(scrollpane);

        addFriend("Friend1");
        addFriend("Friend2");
        addFriend("Friend3");
        addFriend("Friend4");
        addFriend("Friend5");
        addFriend("Friend6");
        addFriend("Friend7");
        addFriend("Friend8");
        addFriend("Friend9");
        addFriend("Friend10");
        addFriend("Friend11");
        addFriend("Friend12");
    }

    public void addFriend(String name){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(name, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).padLeft(10 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new FriendProfile(this, name));

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
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

    @Override
    public void update(float dt) {
        stage.act();
    }

}