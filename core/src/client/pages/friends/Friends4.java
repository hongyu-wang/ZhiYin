package client.pages.friends;


import SQLite.Profile;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.user.User;

public class Friends4 extends Friends4Shell{
    private ScrollPane scrollpane;

    private Table table;

    public Friends4(){
        init();
    }

    protected void init(){
        super.init();

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
        stage.addActor(scrollpane);
        talkerAddFriends();
    }

    public void addFriend(String name, Image image){
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

        final ExecuteToTempState e = new ExecuteToTempState(new FriendProfile(this, name, image));

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
    public void dispose() {

    }


    private void talkerAddFriends(){
        FriendTalker ft = TalkerFactory.getFriendTalker();
        ProfileTalker pt = TalkerFactory.getProfileTalker();

        if(ft.isUpdated()) {
            for (User friend: ft.getAllFriends()) {
                pt.init(friend);
                pt.update(0);
                if (pt.isUpdated()) {
                    String friendName = pt.getName();

                    Pixmap map = new Pixmap(pt.getProfileImage(), 0 ,pt.getProfileImage().length);

                    Image image = new Image(new Texture(map));

                    map.dispose();

                    addFriend(friendName, image);
                }
            }
        }
    }
}