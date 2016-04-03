package server.services.implementations.userService;

import server.model.social.MConversation;
import server.model.user.UserConversations;
import server.services.interfaces.models.UserConversationManager;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserConversationManagerImplementation implements UserConversationManager {
//    @Override
//    public UserConversations requestAllConversations(long convoKey) {
//        UserConversations convos = new UserConversations();
//        convos.setKey(convoKey);
//
//        List<Long> keys = null; //Server request
//        convos.setConvoKeys(keys);
//
//        return convos;
//    }

    @Override
    public UserConversations addConversation(UserConversations conversations, MConversation convo) {
        conversations.getConvoKeys().add(convo.getKey());
        return conversations;
        //TODO change to server
    }
}
