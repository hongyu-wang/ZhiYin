package server.services.implementations.socialService;

import server.model.social.MComment;
import server.services.interfaces.models.CommentManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-06.
 */
public class CommentManagerImplementation implements CommentManager {
    /**
     * Creates a comment object
     *
     * @param music  id's of music that the comment contains
     * @param images id's of images that the comment contains
     * @param audio  id's of audio pieces that the comment contains
     * @return a new comment object
     */
    @Override
    public MComment createComment(List<Long> music, List<Long> images, List<Long> audio, long timestamp, String text, long creator) {
        MComment comment = new MComment();
        comment.setAudio(audio);
        comment.setMusic(music);
        comment.setImages(images);
        comment.setComments(Utils.<Long>newList());
        comment.setTimeStamp(timestamp);
        comment.setText(text);
        comment.setCreator(creator);
        return comment;

    }

    /**
     * Adds music to the given comment object
     *
     * @param music   the id of the piece of music to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment addMusic(Long music, MComment comment) {
        List<Long> musicList = comment.getMusic();
        musicList.add(music);
        comment.setMusic(musicList);
        return comment;
    }

    /**
     * Removes music from the given comment object
     *
     * @param music   the id of the piece of music to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment removeMusic(Long music, MComment comment) {
        List<Long> musicList = comment.getMusic();
        musicList.remove(music);
        comment.setMusic(musicList);
        return comment;
    }

    /**
     * Adds images to the given comment object
     *
     * @param image   the id of the image to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment addImage(Long image, MComment comment) {
        List<Long> imageList = comment.getImages();
        imageList.add(image);
        comment.setMusic(imageList);
        return comment;
    }

    /**
     * Remove images from the given comment object
     *
     * @param image   the id of the image to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment removeImage(Long image, MComment comment) {
        List<Long> imageList = comment.getImages();
        imageList.remove(image);
        comment.setMusic(imageList);
        return comment;
    }

    /**
     * Adds audio pieces to the given comment object
     *
     * @param audio   the id of the audio piece to be added
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment addAudio(Long audio, MComment comment) {
        List<Long> audioList = comment.getAudio();
        audioList.add(audio);
        comment.setMusic(audioList);
        return comment;
    }

    /**
     * Remove audio from the given comment object
     *
     * @param audio   the id of the audio piece to be removed
     * @param comment the given comment object
     * @return the updated comment
     */
    @Override
    public MComment removeAudio(Long audio, MComment comment) {
        List<Long> audioList = comment.getAudio();
        audioList.remove(audio);
        comment.setMusic(audioList);
        return comment;
    }

    /**
     * Adds a like to the given comment
     *
     * @param user    id of the user who liked it
     * @param comment the comment that has been liked
     * @return the updated comment
     */
    @Override
    public MComment like(Long user, MComment comment) {
        List<Long> userList = comment.getLikes();
        userList.remove(user);
        comment.setMusic(userList);
        return comment;
    }

    /**
     * Adds comments to the given comment object
     *
     * @param commentAdd  the id of the comment to be added
     * @param commentOrig the given comment object
     * @return the updated comment
     */
    @Override
    public MComment addComment(Long commentAdd, MComment commentOrig) {
        List<Long> comments = commentOrig.getComments();
        comments.add(commentAdd);
        commentOrig.setComments(comments);
        return commentOrig;
    }

    /**
     * Remove comments from the given comment object
     *
     * @param commentRemove the id of the comment to be removed
     * @param commentOrig   the given comment object
     * @return the updated comment
     */
    @Override
    public MComment removeComment(Long commentRemove, MComment commentOrig) {
        List<Long> comments = commentOrig.getComments();
        comments.remove(commentRemove);
        commentOrig.setComments(comments);
        return commentOrig;
    }

//    /**
//     * Retrieves a comment
//     *
//     * @param comment id of the comment
//     * @return the associated comment
//     */
//    @Override
//    public MComment getComment(long comment) {
//        return null;
//    }
}
