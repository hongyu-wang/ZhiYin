package server.services.interfaces.models;

import server.model.social.MConversation;
import server.model.user.UserConversations;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserConversationManager {

    /**Adds a new conversation to both the user and the server.
     *
     * @param conversations     The user's conversations;
     * @param convo             The new conversation.
     * @return                  The modified user.
     */
    UserConversations addConversation(UserConversations conversations, MConversation convo);
}
