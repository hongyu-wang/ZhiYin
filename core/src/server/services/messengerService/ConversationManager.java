package server.services.messengerService;

import server.model.social.Conversation;
import server.model.social.Message;
import server.model.user.User;
import tools.ServiceList;

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
    public Conversation createConversation(ServiceList<User> users);

    /**
     * Adds a message to the conversation
     *
     * @param message the message to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation addMessage(Message message, Conversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param message the message to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation removeMessage(Message message, Conversation conversation);

    /**
     * Adds a user to the conversation
     *
     * @param user the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation addUser(User user, Conversation conversation);

    /**
     * Removes a message from the conversation
     *
     * @param user the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    public Conversation removeUser(User user, Conversation conversation);


}
