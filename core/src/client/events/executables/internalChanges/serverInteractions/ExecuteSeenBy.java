package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.Friends1;
import client.pages.friends.boxes.FriendBox;
import client.pages.pageInternal.serverClientInteractions.ServerTalker;
import server.model.social.MConversation;
import server.model.social.MMessage;

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
        List<Long> messageList = conversation.getMessageList();
        if(messageList.isEmpty()){
            return;
        }

        List<Long> seenList = conversation.getSeenBy();
        long lastPoster = getLastPoster(messageList.get(messageList.size() - 1));

        if(seenList.size() == 1){
            comparePosters(lastPoster, SENT_UNREAD, RECIEVED_UNREAD);
        }
        else if (seenList.size() == 2){
            comparePosters(lastPoster, SENT_READ, RECIEVED_READ);
        }

        String[] seenBy = {
            "RECEIVED_READ",
            "RECEIVED_UNREAD",
            "SENT_READ",
            "SENT_UNREAD"
        };

        System.out.println("EXECUTESEENBY.execute() -- > " + friendName + ": " + seenBy[friend.getState() - 1]);
    }

    private void comparePosters(long lastPoster, int stateValue_MainUser, int stateValue_Friend){
        if(lastPoster == localDatabase.getMainUser().getKey()){
            friend.setState(stateValue_MainUser);
        }
        else if(lastPoster == localDatabase.getUserKeyByName(friendName)){
            friend.setState(stateValue_Friend);
        }
    }

    private long getLastPoster(long message){
        MMessage mMessage = localDatabase.getModel(message);
        return mMessage.getCreator();
    }

}
