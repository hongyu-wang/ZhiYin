package client.pages.other;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
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
public class MyProfile extends MyProfileShell {
    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;

    private Image profilePic;

    //private ArrayList<Image> artistImages = new ArrayList<>();
    //private ArrayList<ImageButton> artistButtons = new ArrayList<>();
    //private ArrayList<ImageButton> removeButtons = new ArrayList<>();

    public MyProfile(){
//        pull from server for name and image

        init();
    }


    protected void init(){
        super.init();

//        Label label = new Label(name, SkinSingleton.getInstance());
//        label.setPosition(310 * StateManager.M, 1050 * StateManager.M);
//        stage.addActor(label);

//        if(image != null) {
//            image.setBounds(50 * StateManager.M, 967 * StateManager.M, 200 * StateManager.M, 200 * StateManager.M);
//            stage.addActor(image);
//        }

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

//        (new Image(new Texture("Artist/Artist1.png")));
//        addFollowing(new Image(new Texture("Artist/Artist2.png")));
//        addFollowing(new Image(new Texture("Artist/Artist3.png")));
//        addFollowing(new Image(new Texture("Artist/Artist4.png")));
//        addFollowing(new Image(new Texture("Artist/Artist5.png")));

    }

    public void addPost(String post){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(post, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).expand().left().padLeft(10 * StateManager.M);
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

//    public void follow(ArtistProfile profile){
//        ImageButton artistButton = new ImageButton(profile.getImage().getDrawable());
//        artistButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                new ExecuteToTempState(profile).execute();
//            }
//        });
//
//        ImageButton removeButton = new ImageButton(new Image(new Texture("Other/Unfollow@1.0.png")).getDrawable());
//        artistButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                artistButton.remove();
//                removeButton.remove();
//            }
//        });
//
//        following.add(removeButton).width(56 * StateManager.M).height(56 * StateManager.M).padRight(50 * StateManager.M);
//        following.add(artistButton).width(150 * StateManager.M).height(150 * StateManager.M).padRight(50 * StateManager.M);
//    }

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
