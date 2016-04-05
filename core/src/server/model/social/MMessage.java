package server.model.social;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.model.structureModels.TimeStampObject;
import server.model.user.User;

import java.util.List;

/**
 * Message model
 */
public class MMessage extends TimeStampObject{

    /**
     * Id of the MText representation of the message
     */
    private long text;

    /**
     * Id of the creator of the message
     */
    private long creator;

    /**
     * Long key of audio.
     */
    private long audioKey;

    /**
     * Id of users who have seen the message
     */
    private List<Long> seenBy;

    public List<Long> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<Long> seenBy) {
        this.seenBy = seenBy;
    }

    public long getText() {
        return text;
    }

    public void setText(long text) {
        this.text = text;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public long getAudioKey() {
        return audioKey;
    }

    public void setAudioKey(long audioKey) {
        this.audioKey = audioKey;
    }
}