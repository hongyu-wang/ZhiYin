package server.model.social;

import server.model.social.Message;
import server.model.user.User;
import tools.ServiceList;

import java.util.LinkedList;

/**
 * Created by Hairuo on 2016-03-03.
 */
public class Conversation{

    private LinkedList<Message> messageList;

    private ServiceList<User> participants;

    public LinkedList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(LinkedList<Message> messageList) {
        this.messageList = messageList;
    }

    public ServiceList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ServiceList<User> participants) {
        this.participants = participants;
    }
}
