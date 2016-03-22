package client.pages.friends;

import client.pages.friends.boxes.FriendBox;

public class Friends1 extends Friends1Shell{

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

}
