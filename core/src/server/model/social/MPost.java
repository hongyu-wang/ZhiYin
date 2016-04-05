package server.model.social;

import server.model.structureModels.TimeStampObject;

import java.util.List;


/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MPost extends TimeStampObject {


    protected String title;

    /**
     * Id of the user who created the post
     */
    protected long creator;

    /**
     * List of id's of the comments in the post
     */
    protected List<Long> comments;

    /**
     * Id of the MText representation of the description
     */
    protected long text;

    /**
     * List of id's of the users who liked the post
     */
    protected List<Long> likes;

    /**
     * List of id's of the music pieces that the post contains
     */
    protected List<Long> Music;

    /**
     * List of id's of the images that the post contains
     */
    protected List<Long> Images;

    /**
     * List of id's of audio pieces that the post contains
     */
    protected List<Long> Audio;


    public String getTitle(){
        return title;
    }

    public void setTitle(String title){ this.title = title; }

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
