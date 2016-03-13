package server.services.interfaces.models;

import server.model.social.MPost;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-06.
 */
public interface PostManager {

    /**
     * Creates a post object
     *
     * @param music  id's of music that the post contains
     * @param images id's of images that the post contains
     * @param audio  id's of audio pieces that the post contains
     * @return a new post object
     */
    public MPost createPost(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text, long creator);

    /**
     * Adds music to the given post object
     *
     * @param music the id of the piece of music to be added
     * @param post  the given post object
     * @return the updated post
     */
    public MPost addMusic(long music, MPost post);

    /**
     * Removes music from the given post object
     *
     * @param music the id of the piece of music to be removed
     * @param post  the given post object
     * @return the updated post
     */
    public MPost removeMusic(long music, MPost post);

    /**
     * Adds images to the given post object
     *
     * @param image the id of the image to be added
     * @param post  the given post object
     * @return the updated post
     */
    public MPost addImage(long image, MPost post);

    /**
     * Remove images from the given post object
     *
     * @param image the id of the image to be removed
     * @param post  the given post object
     * @return the updated post
     */
    public MPost removeImage(long image, MPost post);

    /**
     * Adds audio pieces to the given post object
     *
     * @param audio the id of the audio piece to be added
     * @param post  the given post object
     * @return the updated post
     */
    public MPost addAudio(long audio, MPost post);

    /**
     * Remove audio from the given post object
     *
     * @param audio the id of the audio piece to be removed
     * @param post  the given post object
     * @return the updated post
     */
    public MPost removeAudio(long audio, MPost post);

    /**
     * Adds a like to the given post
     *
     * @param user id of the user who liked it
     * @param post the post that has been liked
     * @return the updated post
     */
    public MPost like(long user, MPost post);

    /**
     * Adds comments to the given post object
     *
     * @param comment the id of the comment to be added
     * @param post    the given post object
     * @return the updated post
     */
    public MPost addComment(long comment, MPost post);

    /**
     * Remove comments from the given post object
     *
     * @param comment the id of the comment to be removed
     * @param post    the given post object
     * @return the updated post
     */
    public MPost removeComment(long comment, MPost post);


}
