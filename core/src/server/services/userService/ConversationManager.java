package server.services.userService;

import server.model.social.Conversation;
import server.model.social.Message;
import server.model.user.User;
import server.model.user.UserConversations;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ConversationManager {
    /**Requests the server for all conversations the user has.
     *
     * @param user  The username.
     * @return      The UserConversations model of all user conversations.
     */
    UserConversations requestAllConversations(String user);

    /**Adds a new conversation to both the user and the server.
     *
     * @param user  The user.
     * @param convo The new conversation.
     * @return      The modified user.
     */
    User addConversation(User user, Conversation convo);
}
