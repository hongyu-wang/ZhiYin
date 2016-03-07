package server.services.socialService;
import server.model.social.Conversation;
import server.model.social.Message;
import server.model.user.User;
import tools.ServiceList;
import tools.Utils;

import javax.rmi.CORBA.Util;
import java.util.LinkedList;
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
    public Conversation createConversation(List<Long> users){
        Conversation newConvo = new Conversation();
        newConvo.setParticipants(users);
        newConvo.setMessageList(Utils.newList());
        return newConvo;
    }

    /**
     * Adds a message to the conversation
     *
     * @param message the message to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation addMessage(long message, Conversation conversation){
        List<Long> messages = Utils.newList();
        messages.add(message);
        conversation.setMessageList(messages);
        return conversation;
    }

    /**
     * Removes a message from the conversation
     *
     * @param message the message to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation removeMessage(long message, Conversation conversation){
        List<Long> messages = conversation.getMessageList();
        messages.remove(message);
        conversation.setMessageList(messages);
        return conversation;
    }

    /**
     * Adds a user to the conversation
     *
     * @param user the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation addUser(long user, Conversation conversation){
        List<Long> users = conversation.getParticipants();
        users.add(user);
        conversation.setParticipants(users);
        return conversation;
    }

    /**
     * Removes a message from the conversation
     *
     * @param user the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation removeUser(long user, Conversation conversation){
        List<Long> users = conversation.getParticipants();
        users.remove(user);
        conversation.setParticipants(users);
        return conversation;
    }

    /**
     * Retrieves a conversation from the database
     *
     * @param key the id of the conversation
     * @return the conversation associated with the id
     */
    @Override
    public Conversation requestConversation(long key){
        //TODO implement this
        return null;
    }
}
