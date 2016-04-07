package client.pages.friends;


import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.user.User;

public class Friends4 extends Friends4Shell implements Gesturable{
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
        scrollpane.setBounds(0, 117*M, 750*M, 1100*M);
        stage.addActor(scrollpane);
        talkerAddFriends();
    }

    public void addFriend(String name, Image image){
        Table t = new Table();
        t.add(new Label(name, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        t.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26 * M).expand().right().padRight(50*M);
        disposables.add(tx);
        t.row();
        t.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50*M);

        Stack s = new Stack();
        //s.setSize(750*M, 116*M);
        s.add(new Image(tx = new Texture("Home/BlackBG@1.0.png")));
        disposables.add(tx);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new FriendProfile(this, name, image), TransitionType.RIGHT_TO_LEFT);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750*M).height(116*M);
        table.row();
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

                    Image image = new Image(tx = new Texture(map));
                    disposables.add(tx);
                    disposables.add(map);

                    addFriend(friendName, image);
                    System.out.println("FUCK ME");
                }
            }
        }
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.FRIENDS1, TransitionType.LEFT_TO_RIGHT).execute();
    }
}