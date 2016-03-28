package client.pages.friends;

import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import server.model.user.User;

import java.util.List;

public class Friends1 extends Friends1Shell{

    private Table table;

    public Friends1(){
        init();
    }

    public void init(){
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 *  StateManager.M);
        table.top();

        stage.addActor(table);

        //table.setDebug(true);

        talkerAddFriends();
    }


    public void addBox(FriendBox box){
        table.add(box.getStack()).width(750 * StateManager.M).height(117 * StateManager.M);
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

                    addBox(new FriendBox(1, friendName));
                }
            }
        }
    }
}
