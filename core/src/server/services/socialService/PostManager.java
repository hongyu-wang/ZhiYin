package server.services.socialService;

import server.model.media.Text;
import server.model.social.Post;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-06.
 */
public interface PostManager {

    /**
     * Creates a post object
     *
     * @param music id's of music that the post contains
     * @param images id's of images that the post contains
     * @param audio id's of audio pieces that the post contains
     * @return a new post object
     */
    public Post createPost(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text);

    /**
     * Adds music to the given post object
     *
     * @param music the id of the piece of music to be added
     * @param post the given post object
     * @return the updated post
     */
    public Post addMusic(Long music, Post post);

    /**
     * Removes music from the given post object
     *
     * @param music the id of the piece of music to be removed
     * @param post the given post object
     * @return the updated post
     */
    public Post removeMusic(Long music, Post post);

    /**
     * Adds images to the given post object
     *
     * @param image the id of the image to be added
     * @param post the given post object
     * @return the updated post
     */
    public Post addImage(Long image, Post post);

    /**
     * Remove images from the given post object
     *
     * @param image the id of the image to be removed
     * @param post the given post object
     * @return the updated post
     */
    public Post removeImage(Long image, Post post);

    /**
     * Adds audio pieces to the given post object
     *
     * @param audio the id of the audio piece to be added
     * @param post the given post object
     * @return the updated post
     */
    public Post addAudio(Long audio, Post post);

    /**
     * Remove audio from the given post object
     *
     * @param audio the id of the audio piece to be removed
     * @param post the given post object
     * @return the updated post
     */
    public Post removeAudio(Long audio, Post post);

    /**
     * Adds a like to the given post
     *
     * @param user id of the user who liked it
     * @param post the post that has been liked
     * @return the updated post
     */
    public Post like(Long user, Post post);

    /**
     * Adds comments to the given post object
     *
     * @param comment the id of the comment to be added
     * @param post the given post object
     * @return the updated post
     */
    public Post addComment(Long comment, Post post);

    /**
     * Remove comments from the given post object
     *
     * @param comment the id of the comment to be removed
     * @param post the given post object
     * @return the updated post
     */
    public Post removeComment(Long comment, Post post);



}
