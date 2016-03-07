package server.model.social;

import server.model.media.Image;
import server.model.media.Music;
import server.model.media.Text;
import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Message extends ServerModel {
    private Text text;
    private long creator;
    private long timeStamp;
    private List<User> seenBy;

    public List<User> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<User> seenBy) {
        this.seenBy = seenBy;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
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
