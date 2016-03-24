package client.pages.friends;

import client.pages.friends.boxes.FriendBox;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Friends1 extends Friends1Shell{

    private Table table;

    public void init(){
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 *  StateManager.M);
        table.top();

        stage.addActor(table);

        FriendBox box1 = new FriendBox(1, "Friend1");
        FriendBox box2 = new FriendBox(1, "Friend2");
        FriendBox box3 = new FriendBox(1, "Friend3");
        FriendBox box4 = new FriendBox(1, "Friend4");

        addBox(box1);
        addBox(box2);
        addBox(box3);
        addBox(box4);

        //pullDataFromServer();
    }


    public void addBox(FriendBox box){
        table.add(box.getTable());
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


    public void pullDataFromServer(){
//        FriendTalker ft = TalkerFactory.getFriendTalker();
//        ProfileTalker pt = TalkerFactory.getProfileTalker();
//
//        ft.update(0);
//        List<User> users = ft.getAllFriends();
//        for (int i = 2; i < 4; i ++){
//            pt.init(users.get(i-2));
//            pt.update(0);
//            addFriendBox(1, pt.getName(), i);
//        }
    }
}
