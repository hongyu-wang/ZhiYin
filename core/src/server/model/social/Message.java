package server.model.social;

import server.model.media.Image;
import server.model.media.Music;
import server.model.user.User;
import tools.ServiceList;

import javax.xml.ws.Service;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Message{
    private String text;
    private User creator;
    private int timeStamp;
    private ServiceList<User> seenBy;

    //TBD
    private ServiceList<Image> images;
    private ServiceList<Music> music;

    public ServiceList<User> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(ServiceList<User> seenBy) {
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

    public ServiceList<Image> getImages() {
        return images;
    }

    public void setImages(ServiceList<Image> images) {
        this.images = images;
    }

    public ServiceList<Music> getMusic() {
        return music;
    }

    public void setMusic(ServiceList<Music> music) {
        this.music = music;
    }
}
