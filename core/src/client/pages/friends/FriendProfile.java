package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class FriendProfile extends FriendProfileShell {

    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;

    public FriendProfile(State previousState, String name){
        this.previousState = previousState;
        this.name = name;
        init();
    }

    public void init(){
        super.init();

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteToTempState(previousState));
        add(backButton);

        Label label = new Label(name, SkinSingleton.getInstance());
        label.setPosition(310 * StateManager.M, 1050 * StateManager.M);
        stage.addActor(label);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0,  570 * StateManager.M, 750 * StateManager.M, 250 * StateManager.M);
        stage.addActor(scrollpane);

        following = new Table();
        following.top();

        scrollpane2 = new ScrollPane(following);
        scrollpane2.setBounds(50 * StateManager.M,  350 * StateManager.M, 700 * StateManager.M, 150 * StateManager.M);
        stage.addActor(scrollpane2);

        addPost("post1");
        addPost("post2");
        addPost("post3");
        addPost("post4");
        addPost("post5");

        addFollowing(new Image(new Texture("Artist/Artist1.png")));
        addFollowing(new Image(new Texture("Artist/Artist2.png")));
        addFollowing(new Image(new Texture("Artist/Artist3.png")));
        addFollowing(new Image(new Texture("Artist/Artist4.png")));
        addFollowing(new Image(new Texture("Artist/Artist5.png")));

    }

    public void addPost(String post){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(post, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).padLeft(10 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.DIARY1).execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();
    }

    public void addFollowing(Image image){
        following.add(image).width(150 * StateManager.M).height(150 * StateManager.M).padRight(50 * StateManager.M);
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