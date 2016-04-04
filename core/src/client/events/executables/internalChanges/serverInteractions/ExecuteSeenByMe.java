package client.events.executables.internalChanges.serverInteractions;

import client.pages.pageInternal.serverClientInteractions.ServerTalker;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import server.model.social.MConversation;
import server.model.structureModels.ServerModel;
import server.model.user.UserConversations;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-04.
 */
public class ExecuteSeenByMe implements ExecuteServer{
    private String friendName;
    private ExecuteUpdate update;
    public ExecuteSeenByMe(String friendName, ExecuteUpdate ex){
        this.friendName = friendName;
        this.update = ex;
    }

    @Override
    public void execute() {
        update.execute();

        MConversation conversation = ServerTalker.getConversationByFriend(friendName);

        if(conversation.getSeenBy().contains(localDatabase.getMainUser().getKey())){
            return;
        }

        conversation.getSeenBy().add(localDatabase.getMainUser().getKey());

        List<ServerModel> pushList = Utils.newList();
        pushList.add(conversation);
        localDatabase.pushModel(pushList);
    }
}
