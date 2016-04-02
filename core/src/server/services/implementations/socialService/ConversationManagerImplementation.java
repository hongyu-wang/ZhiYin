package server.services.implementations.socialService;

import tools.serverTools.databases.LocalDatabaseFactory;
import server.model.social.MConversation;
import server.services.interfaces.models.ConversationManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-03.
 */
public class ConversationManagerImplementation implements ConversationManager {

    /**
     * Creates a conversation given a list of users
     *
     * @param users list of users who started the conversation
     * @return the created conversation
     */
    @Override
    public MConversation createConversation(List<Long> users) {
        MConversation newConvo = new MConversation();

        newConvo.setParticipants(users);
        newConvo.setMessageList(Utils.<Long>newList());
        return newConvo;
    }

    /**
     * Adds a message to the conversation
     *
     * @param message      the message to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public MConversation addMessage(long message, MConversation conversation) {
        List<Long> messages = Utils.newList();
        messages.add(message);
        conversation.setMessageList(messages);
        return conversation;
    }

    /**
     * Removes a message from the conversation
     *
     * @param message      the message to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public MConversation removeMessage(long message, MConversation conversation) {
        List<Long> messages = conversation.getMessageList();
        messages.remove(message);
        conversation.setMessageList(messages);
        return conversation;
    }

    /**
     * Adds a user to the conversation
     *
     * @param user         the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public MConversation addUser(long user, MConversation conversation) {
        List<Long> users = conversation.getParticipants();
        users.add(user);
        conversation.setParticipants(users);
        return conversation;
    }

    /**
     * Removes a message from the conversation
     *
     * @param user         the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public MConversation removeUser(long user, MConversation conversation) {
        List<Long> users = conversation.getParticipants();
        users.remove(user);
        conversation.setParticipants(users);
        return conversation;
    }

//    /**
//     * Retrieves a conversation from the database
//     *
//     * @param key the id of the conversation
//     * @return the conversation associated with the id
//     */
//    @Override
//    public MConversation getConversation(long key) {
//        //TODO implement this
//        return null;
//    }
}
