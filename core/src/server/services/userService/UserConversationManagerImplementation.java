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
    public UserConversations requestAllConversations(long userKey) {
        UserConversations convos = new UserConversations();

        List<Long> keys = null; //Server request
        convos.setConvoKeys(keys);

        List<Conversation> conversations = new ServiceList<Conversation>();
        for(long key: convos.getConvoKeys()){
            Conversation convo = new ConversationManagerImplementation().requestConversation(key);
            conversations.add(convo);
        }
        convos.setConversations(conversations);

        return convos;
        //TODO Request from server.
    }

    @Override
    public User addConversation(User user, Conversation convo) {
        user.getConversations().getConvoKeys().add(convo.getKey());
        user.getConversations().getConversations().add(convo);
        return user;
        //TODO change to server
    }
}
