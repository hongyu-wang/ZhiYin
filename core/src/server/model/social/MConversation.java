package server.model.social;

import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Conversation model
 */
public class MConversation extends ServerModel {

    /**
     * List of id's of the messages that have been sent in the conversation
     */
    private List<Long> messageList;

    /**
     * List of id's of the users in the conversation
     */
    private List<Long> participants;

    private List<Long> seenBy;

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

    public List<Long> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<Long> seenBy) {
        this.seenBy = seenBy;
    }
}
