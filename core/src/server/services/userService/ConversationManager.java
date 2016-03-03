package server.services.userService;

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
     * @return  The UserConversations model of all user conversations.
     */
    UserConversations requestAllConversations(String user);

    /**Returns all messages between any two different users.
     *
     * @param userConversations The model of conversations.
     * @param user1     The first user.
     * @param user2     The second user.
     * @return      The
     */

}
