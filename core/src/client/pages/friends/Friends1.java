package client.pages.friends;

import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import server.model.user.User;

import java.util.List;

public class Friends1 extends Friends1Shell{
    public void init(){
        super.init();

        pullDataFromServer();
    }

    public void addFriendBox(int status, String name, int multiplier){
        FriendBox box = new FriendBox(1334 - 117 * multiplier, status, name);
        stage.addActor(box.getTable());

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
        FriendTalker ft = TalkerFactory.getFriendTalker();
        ProfileTalker pt = TalkerFactory.getProfileTalker();

        ft.update(0);
        List<User> users = ft.getAllFriends();
        for (int i = 2; i < 4; i ++){
            pt.init(users.get(i-2));
            pt.update(0);
            addFriendBox(1, pt.getName(), i);
        }
    }
}
