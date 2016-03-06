package server.model.social;

import server.model.social.Message;
import server.model.user.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hairuo on 2016-03-03.
 */
public class Conversation{

    private LinkedList<Message> messageList;

    private List<User> participants;

    public LinkedList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(LinkedList<Message> messageList) {
        this.messageList = messageList;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
