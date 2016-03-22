package client.pages.friends;

import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;

public class Friends1 extends Friends1Shell{
    FriendTalker ft;
    public void init(){
        super.init();

        FriendBox box1 = new FriendBox(1334 - 117 * 2, 1, "Name1");
        stage.addActor(box1.getTable());

        FriendBox box2 = new FriendBox(1334 - 117 * 3, 1, "Name2");
        stage.addActor(box2.getTable());

        FriendBox box3 = new FriendBox(1334 - 117 * 4, 1, "Name3");
        stage.addActor(box3.getTable());
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
        ft.pull();

    }
}
