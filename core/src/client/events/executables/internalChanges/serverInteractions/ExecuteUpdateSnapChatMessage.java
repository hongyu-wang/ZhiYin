package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends2;
import server.model.media.MSnapShot;
import server.model.user.User;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteUpdateSnapChatMessage extends ExecuteUpdate {
    private Friends2 friend2;
    private long friend;
    private List<Long> snapChats;

    public ExecuteUpdateSnapChatMessage(Friends2 friend2){
        this.friend2 = friend2;
        this.friend = localDatabase.getUserKeyByName(friend2.getFriendName());
        snapChats = Utils.newList();
    }

    @Override
    public void execute() {
        User friend = localDatabase.getModel(this.friend);
        User user = localDatabase.getMainUser();

        if(user.getSnapChat() != 0){
            if(snapChats.contains(user.getSnapChat())){
                return;
            }
            MSnapShot snapShot = localDatabase.getModel(user.getSnapChat());

            snapChats.add(user.getSnapChat());
        }
    }
}
