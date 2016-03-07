package server.model.social;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMessage extends ServerModel {
    private MText text;
    private long creator;
    private long timeStamp;
    private List<User> seenBy;

    public List<User> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<User> seenBy) {
        this.seenBy = seenBy;
    }

    public MText getText() {
        return text;
    }

    public void setText(MText text) {
        this.text = text;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
