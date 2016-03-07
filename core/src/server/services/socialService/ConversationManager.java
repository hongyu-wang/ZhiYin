package server.services.socialService;

import server.model.social.Conversation;
import server.model.social.Message;
import server.model.user.User;
import tools.ServiceList;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-03.
 */
public interface ConversationManager {

    /**
     * Creates a conversation given a list of users
     *
     * @param users list of users who started the conversation
     * @return the created conversation
     */
    public Conversation createConversation(List<Long> users);

    /**
     * Adds a message to the conversation
     *
     * @param message the message to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation addMessage(long message, Conversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param message the message to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation removeMessage(long message, Conversation conversation);

    /**
     * Adds a user to the conversation
     *
     * @param user the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation addUser(long user, Conversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param user the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation removeUser(long user, Conversation conversation);

    /**
     * Retrieves a conversation from the database
     *
     * @param key the id of the conversation
     * @return the conversation associated with the id
     */
    public Conversation requestConversation(long key);


}
