package server.model.social;

import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hairuo on 2016-03-03.
 */
public class MConversation extends ServerModel {

    private List<Long> messageList;

    private List<Long> participants;

    public List<Long> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Long> messageList) {
        this.messageList = messageList;
    }

    public List<Long> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Long> participants) {
        this.participants = participants;
    }
}
