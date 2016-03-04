package server.services.messengerService;

import server.model.social.Conversation;
import server.model.social.Message;
import server.model.user.User;
import tools.ServiceList;

import java.util.LinkedList;

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
    public Conversation createConversation(ServiceList<User> users){
        Conversation newConvo = new Conversation();
        newConvo.setParticipants(users);
        newConvo.setMessageList(new LinkedList<Message>());
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
    public Conversation addMessage(Message message, Conversation conversation){
        LinkedList<Message> messages = new LinkedList<>();
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
    public Conversation removeMessage(Message message, Conversation conversation){

    }

    /**
     * Adds a user to the conversation
     *
     * @param user the user to be added
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation addUser(User user, Conversation conversation){
        return null;
    }

    /**
     * Removes a message from the conversation
     *
     * @param user the user to be removed
     * @param conversation the conversation in question
     * @return the updated conversation
     */
    @Override
    public Conversation removeUser(User user, Conversation conversation){
        return null;
    }
}
