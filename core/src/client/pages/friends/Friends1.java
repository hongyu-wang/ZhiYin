package client.pages.friends;

import client.pages.friends.boxes.FriendBox;

public class Friends1 extends Friends1Shell{

    public void init(){
        super.init();

        FriendBox box1 = new FriendBox(0, 1, "Name");
        stage.addActor(box1.getTable());
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
