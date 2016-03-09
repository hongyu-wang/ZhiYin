package server.model.social;

import server.model.structureModels.ServerModel;

import java.util.List;


/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MPost extends ServerModel {
    protected long creator;
    protected List<Long> comments;
    protected long text;
    protected List<Long> likes;
    protected List<Long> Music;
    protected List<Long> Images;
    protected List<Long> Audio;
    protected long timeStamp;

    public List<Long> getComments() {
        return comments;
    }

    public void setComments(List<Long> comments) {
        this.comments = comments;
    }

    public long getText() {
        return text;
    }

    public void setText(long text) {
        this.text = text;
    }

    public List<Long> getMusic() {
        return Music;
    }

    public void setMusic(List<Long> music) {
        Music = music;
    }

    public List<Long> getImages() {
        return Images;
    }

    public void setImages(List<Long> images) {
        Images = images;
    }

    public List<Long> getAudio() {
        return Audio;
    }

    public void setAudio(List<Long> audio) {
        Audio = audio;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<Long> getLikes() {
        return likes;
    }

    public void setLikes(List<Long> likes) {
        this.likes = likes;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }
}