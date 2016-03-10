package server.services.socialService;

import server.model.social.MConversation;

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
    public MConversation createConversation(List<Long> users);

    /**
     * Adds a message to the conversation
     *
     * @param message      the message to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public MConversation addMessage(long message, MConversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param message      the message to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public MConversation removeMessage(long message, MConversation conversation);

    /**
     * Adds a user to the conversation
     *
     * @param user         the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public MConversation addUser(long user, MConversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param user         the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public MConversation removeUser(long user, MConversation conversation);

    /**
     * Retrieves a conversation from the database
     *
     * @param key the id of the conversation
     * @return the conversation associated with the id
     */
    public MConversation getConversation(long key);


}
