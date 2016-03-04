package server.services.userService;

import server.model.social.Conversation;
import server.model.user.User;
import server.model.user.UserConversations;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class ConversationManagerImplementation implements ConversationManager {
    @Override
    public UserConversations requestAllConversations(String user) {
        UserConversations convos = new UserConversations();
        return convos;
        //TODO Request from server.
    }

    @Override
    public User addConversation(User user, Conversation convo) {
        user.getConversations().getConvoKeys().add(convo.getKey());
        user.getConversations().getConversations().add(convo);
        return user;
        //TODO implement keys.
        //TODO change to server
    }
}
