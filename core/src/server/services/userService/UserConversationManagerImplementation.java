package server.services.userService;

import server.model.social.Conversation;
import server.model.user.User;
import server.model.user.UserConversations;
import server.services.socialService.ConversationManagerImplementation;
import tools.ServiceList;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserConversationManagerImplementation implements UserConversationManager {
    @Override
    public UserConversations requestAllConversations(long convoKey) {
        UserConversations convos = new UserConversations();
        convos.setKey(convoKey);

        List<Long> keys = null; //Server request
        convos.setConvoKeys(keys);

        return convos;
        //TODO Request from server.
    }

    @Override
    public UserConversations addConversation(UserConversations conversations, Conversation convo) {
        conversations.getConvoKeys().add(convo.getKey());
        return conversations;
        //TODO change to server
    }
}
