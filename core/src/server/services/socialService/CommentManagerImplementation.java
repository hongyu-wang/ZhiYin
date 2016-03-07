package server.services.socialService;

import server.model.social.Comment;
import tools.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-06.
 */
public class CommentManagerImplementation implements CommentManager{

    /**
     * Creates a comment object
     *
     * @param music             id's of music that the comment contains
     * @param images            id's of images that the comment contains
     * @param audio             id's of audio pieces that the comment contains
     * @return                  a new comment object
     */
    @Override
    public Comment createComment(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text){
        Comment comment = new Comment();
        comment.setAudio(audio);
        comment.setMusic(music);
        comment.setImages(images);
        comment.setComments(Utils.newList());
        comment.setTimeStamp(timestamp);
        comment.setText(text);
        return comment;

    }

    /**
     * Adds music to the given comment object
     *
     * @param music             the id of the piece of music to be added
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment addMusic(Long music, Comment comment){
        List<Long> musicList = comment.getMusic();
        musicList.add(music);
        comment.setMusic(musicList);
        return comment;
    }

    /**
     * Removes music from the given comment object
     *
     * @param music             the id of the piece of music to be removed
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment removeMusic(Long music, Comment comment){
        List<Long> musicList = comment.getMusic();
        musicList.remove(music);
        comment.setMusic(musicList);
        return comment;
    }

    /**
     * Adds images to the given comment object
     *
     * @param image             the id of the image to be added
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment addImage(Long image, Comment comment){
        List<Long> imageList = comment.getImages();
        imageList.add(image);
        comment.setMusic(imageList);
        return comment;
    }

    /**
     * Remove images from the given comment object
     *
     * @param image             the id of the image to be removed
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment removeImage(Long image, Comment comment){
        List<Long> imageList = comment.getImages();
        imageList.remove(image);
        comment.setMusic(imageList);
        return comment;
    }

    /**
     * Adds audio pieces to the given comment object
     *
     * @param audio             the id of the audio piece to be added
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment addAudio(Long audio, Comment comment){
        List<Long> audioList = comment.getAudio();
        audioList.add(audio);
        comment.setMusic(audioList);
        return comment;
    }

    /**
     * Remove audio from the given comment object
     *
     * @param audio             the id of the audio piece to be removed
     * @param comment           the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment removeAudio(Long audio, Comment comment){
        List<Long> audioList = comment.getAudio();
        audioList.remove(audio);
        comment.setMusic(audioList);
        return comment;
    }

    /**
     * Adds a like to the given comment
     *
     * @param user              id of the user who liked it
     * @param comment           the comment that has been liked
     * @return                  the updated comment
     */
    @Override
    public Comment like(Long user, Comment comment){
        List<Long> userList = comment.getLikes();
        userList.remove(user);
        comment.setMusic(userList);
        return comment;
    }

    /**
     * Adds comments to the given comment object
     *
     * @param commentAdd        the id of the comment to be added
     * @param commentOrig       the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment addComment(Long commentAdd, Comment commentOrig){
        List<Long> comments = commentOrig.getComments();
        comments.add(commentAdd);
        commentOrig.setComments(comments);
        return commentOrig;
    }

    /**
     * Remove comments from the given comment object
     *
     * @param commentRemove     the id of the comment to be removed
     * @param commentOrig       the given comment object
     * @return                  the updated comment
     */
    @Override
    public Comment removeComment(Long commentRemove, Comment commentOrig){
        List<Long> comments = commentOrig.getComments();
        comments.remove(commentRemove);
        commentOrig.setComments(comments);
        return commentOrig;
    }
}
