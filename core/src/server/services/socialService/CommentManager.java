package server.services.socialService;

import server.model.social.Comment;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-06.
 */
public interface CommentManager {
    /**
     * Creates a comment object
     *
     * @param music id's of music that the comment contains
     * @param images id's of images that the comment contains
     * @param audio id's of audio pieces that the comment contains
     * @return a new comment object
     */
    public Comment createComment(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text);

    /**
     * Adds music to the given comment object
     *
     * @param music the id of the piece of music to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment addMusic(Long music, Comment comment);

    /**
     * Removes music from the given comment object
     *
     * @param music the id of the piece of music to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment removeMusic(Long music, Comment comment);

    /**
     * Adds images to the given comment object
     *
     * @param image the id of the image to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment addImage(Long image, Comment comment);

    /**
     * Remove images from the given comment object
     *
     * @param image the id of the image to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment removeImage(Long image, Comment comment);

    /**
     * Adds audio pieces to the given comment object
     *
     * @param audio the id of the audio piece to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment addAudio(Long audio, Comment comment);

    /**
     * Remove audio from the given comment object
     *
     * @param audio the id of the audio piece to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public Comment removeAudio(Long audio, Comment comment);

    /**
     * Adds a like to the given comment
     *
     * @param user id of the user who liked it
     * @param comment the comment that has been liked
     * @return the updated comment
     */
    public Comment like(Long user, Comment comment);

    /**
     * Adds comments to the given comment object
     *
     * @param commentAdd the id of the comment to be added
     * @param commentOrig the given comment object
     * @return the updated comment
     */
    public Comment addComment(Long commentAdd, Comment commentOrig);

    /**
     * Remove comments from the given comment object
     *
     * @param commentRemove the id of the comment to be removed
     * @param commentOrig the given comment object
     * @return the updated comment
     */
    public Comment removeComment(Long commentRemove, Comment commentOrig);
}
