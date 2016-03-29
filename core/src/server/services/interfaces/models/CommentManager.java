package server.services.interfaces.models;

import server.model.social.MComment;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-06.
 */
public interface CommentManager {
    /**
     * Creates a comment object
     *
     * @param music  id's of music that the comment contains
     * @param images id's of images that the comment contains
     * @param audio  id's of audio pieces that the comment contains
     * @return a new comment object
     */
    public MComment createComment(List<Long> music, List<Long> images, List<Long> audio, long timestamp, String text, long creator);

    /**
     * Adds music to the given comment object
     *
     * @param music   the id of the piece of music to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment addMusic(Long music, MComment comment);

    /**
     * Removes music from the given comment object
     *
     * @param music   the id of the piece of music to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment removeMusic(Long music, MComment comment);

    /**
     * Adds images to the given comment object
     *
     * @param image   the id of the image to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment addImage(Long image, MComment comment);

    /**
     * Remove images from the given comment object
     *
     * @param image   the id of the image to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment removeImage(Long image, MComment comment);

    /**
     * Adds audio pieces to the given comment object
     *
     * @param audio   the id of the audio piece to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment addAudio(Long audio, MComment comment);

    /**
     * Remove audio from the given comment object
     *
     * @param audio   the id of the audio piece to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    public MComment removeAudio(Long audio, MComment comment);

    /**
     * Adds a like to the given comment
     *
     * @param user    id of the user who liked it
     * @param comment the comment that has been liked
     * @return the updated comment
     */
    public MComment like(Long user, MComment comment);

    /**
     * Adds comments to the given comment object
     *
     * @param commentAdd  the id of the comment to be added
     * @param commentOrig the given comment object
     * @return the updated comment
     */
    public MComment addComment(Long commentAdd, MComment commentOrig);

    /**
     * Remove comments from the given comment object
     *
     * @param commentRemove the id of the comment to be removed
     * @param commentOrig   the given comment object
     * @return the updated comment
     */
    public MComment removeComment(Long commentRemove, MComment commentOrig);
}
