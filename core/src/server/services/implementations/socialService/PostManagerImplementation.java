package server.services.implementations.socialService;

import server.model.social.MPost;
import server.services.interfaces.models.PostManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-06.
 */
public class PostManagerImplementation implements PostManager {
    /**
     * Creates a post object
     *
     * @param music  id's of music that the post contains
     * @param images id's of images that the post contains
     * @param audio  id's of audio pieces that the post contains
     * @return a new post object
     */
    @Override
    public MPost createPost(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text, long creator) {
        MPost post = new MPost();
        post.setAudio(audio);
        post.setMusic(music);
        post.setImages(images);
        post.setComments(Utils.<Long>newList());
        post.setTimeStamp(timestamp);
        post.setText(text);
        post.setCreator(creator);
        return post;

    }

    /**
     * Adds music to the given post object
     *
     * @param music the id of the piece of music to be added
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost addMusic(long music, MPost post) {
        List<Long> musicList = post.getMusic();
        musicList.add(music);
        post.setMusic(musicList);
        return post;
    }

    /**
     * Removes music from the given post object
     *
     * @param music the id of the piece of music to be removed
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost removeMusic(long music, MPost post) {
        List<Long> musicList = post.getMusic();
        musicList.remove(music);
        post.setMusic(musicList);
        return post;
    }

    /**
     * Adds images to the given post object
     *
     * @param image the id of the image to be added
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost addImage(long image, MPost post) {
        List<Long> imageList = post.getImages();
        imageList.add(image);
        post.setMusic(imageList);
        return post;
    }

    /**
     * Remove images from the given post object
     *
     * @param image the id of the image to be removed
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost removeImage(long image, MPost post) {
        List<Long> imageList = post.getImages();
        imageList.remove(image);
        post.setMusic(imageList);
        return post;
    }

    /**
     * Adds audio pieces to the given post object
     *
     * @param audio the id of the audio piece to be added
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost addAudio(long audio, MPost post) {
        List<Long> audioList = post.getAudio();
        audioList.add(audio);
        post.setMusic(audioList);
        return post;
    }

    /**
     * Remove audio from the given post object
     *
     * @param audio the id of the audio piece to be removed
     * @param post  the given post object
     * @return the updated post
     */
    @Override
    public MPost removeAudio(long audio, MPost post) {
        List<Long> audioList = post.getAudio();
        audioList.remove(audio);
        post.setMusic(audioList);
        return post;
    }

    /**
     * Adds a like to the given post
     *
     * @param user id of the user who liked it
     * @param post the post that has been liked
     * @return the updated post
     */
    @Override
    public MPost like(long user, MPost post) {
        List<Long> userList = post.getLikes();
        userList.remove(user);
        post.setMusic(userList);
        return post;
    }

    /**
     * Adds comments to the given post object
     *
     * @param comment the id of the comment to be added
     * @param post    the given post object
     * @return the updated post
     */
    @Override
    public MPost addComment(long comment, MPost post) {
        List<Long> comments = post.getComments();
        comments.add(comment);
        post.setComments(comments);
        return post;
    }

    /**
     * Remove comments from the given post object
     *
     * @param comment the id of the comment to be removed
     * @param post    the given post object
     * @return the updated post
     */
    @Override
    public MPost removeComment(long comment, MPost post) {
        List<Long> comments = post.getComments();
        comments.remove(comment);
        post.setComments(comments);
        return post;
    }

//    /**
//     * Retrieves a post from the server
//     *
//     * @param post the id of the post
//     * @return the associated post
//     */
//    @Override
//    public MPost getPost(long post) {
//        return null;
//    }
}
