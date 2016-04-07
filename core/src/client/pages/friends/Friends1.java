package client.pages.friends;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.friends.boxes.FriendBox;
import client.pages.other.TransitionType;
import client.pages.pageInternal.serverClientInteractions.FriendTalker;
import client.pages.pageInternal.serverClientInteractions.ProfileTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import server.model.user.User;

public class Friends1 extends Friends1Shell implements Gesturable{

    private Table table;

    public Friends1(){
        init();
    }

    public void init(){
        super.init();

        table = new Table();
        table.setBounds(0, 117*M, 750*M, 1100*M);
        table.top();
        stage.addActor(table);

        talkerAddFriends();
    }


    public void addBox(FriendBox box){
        table.add(box.getTable()).width(750*M);
        table.row();
        disposables.add(box);
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

                    addBox(new FriendBox(this, 1, friendName));
                }
            }
        }
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(!gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.FRIENDS4, TransitionType.RIGHT_TO_LEFT).execute();
    }
}
