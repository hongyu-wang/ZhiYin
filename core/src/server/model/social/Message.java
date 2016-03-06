package server.model.social;

import server.model.media.Image;
import server.model.media.Music;
import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Message extends ServerModel {
    private String text;
    private User creator;
    private int timeStamp;
    private List<User> seenBy;

    //TBD
    private List<Image> images;
    private List<Music> music;

    public List<User> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(List<User> seenBy) {
        this.seenBy = seenBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }
}
