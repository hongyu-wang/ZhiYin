package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends1;
import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.ServerTalker;
import server.model.social.MConversation;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-04.
 */
public class ExecuteSeenBy extends ExecuteUpdate {
    private FriendBox friend;
    private String friendName;

    public ExecuteSeenBy(FriendBox friend, String friendName){
        this.friend = friend;
        this.friendName = friendName;
    }

    @Override
    public void execute() {
        MConversation conversation = ServerTalker.getConversationByFriend(friendName);

        List<Long> seenList = conversation.getSeenBy();

        if(seenList.size() == 1){
            if(seenList.get(0).equals(localDatabase.getUserKeyByName(friendName))){
                friend.setState(2);
            }
            else if(seenList.get(0).equals(localDatabase.getMainUser().getKey())){
                friend.setState(4);
            }
        }
        else if(seenList.size() == 2){
            if(friend.getState() == 2){
                friend.setState(1);
            }
            else if(friend.getState() == 4){
                friend.setState(3);
            }
        }

        String[] seenBy = {
            "RECEIVED",
            "RECEIVED",
            "SENT",
            "SENT"
        };

        System.out.println("EXECUTESEENBY.execute() -- > " + friendName + ": " + seenBy[friend.getState() - 1]);
    }
}
