package server.model.social;

import server.model.structureModels.ServerModel;

import java.util.List;

/**
 * Comment model
 * Very similar to post right now
 */
public class MComment extends ServerModel {

    /**
     * Id of the MText representation of the comment
     */
    private long text;

    /**
     * List of id's of the users who liked the comment
     */
    private List<Long> likes;

    /**
     * List of id's of of the Music pieces inside the comment
     */
    private List<Long> Music;

    /**
     * List of id's of of the images inside the comment
     */
    private List<Long> Images;

    /**
     * List of id's of the audio pieces inside the comment
     */
    private List<Long> Audio;

    /**
     * List of id's of the comments of the comment
     */
    private List<Long> comments;

    /**
     * Long representation of the timestamp of the comment
     */
    private long timeStamp;

    public long getText() {
        return text;
    }

    public void setText(long text) {
        this.text = text;
    }

    public List<Long> getLikes() {
        return likes;
    }

    public void setLikes(List<Long> likes) {
        this.likes = likes;
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

    public void setImages(List<Long> image) {
        Images = image;
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

    public List<Long> getComments() {
        return comments;
    }

    public void setComments(List<Long> comments) {
        this.comments = comments;
    }

}
