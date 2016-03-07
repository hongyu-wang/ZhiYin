package server.services.socialService;

import server.model.media.Text;
import server.model.social.Post;
import tools.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-06.
 */
public class PostManagerImplementation implements PostManager {
    /**
     * Creates a post object
     *
     * @param music id's of music that the post contains
     * @param images id's of images that the post contains
     * @param audio id's of audio pieces that the post contains
     * @return a new post object
     */
    @Override
    public Post createPost(List<Long> music, List<Long> images, List<Long> audio, long timestamp, long text){
        Post post = new Post();
        post.setAudio(audio);
        post.setMusic(music);
        post.setImages(images);
        post.setComments(Utils.newList());
        post.setTimeStamp(timestamp);
        post.setText(text);
        return post;

    }

    /**
     * Adds music to the given post object
     *
     * @param music the id of the piece of music to be added
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post addMusic(Long music, Post post){
        List<Long> musicList = post.getMusic();
        musicList.add(music);
        post.setMusic(musicList);
        return post;
    }

    /**
     * Removes music from the given post object
     *
     * @param music the id of the piece of music to be removed
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post removeMusic(Long music, Post post){
        List<Long> musicList = post.getMusic();
        musicList.remove(music);
        post.setMusic(musicList);
        return post;
    }

    /**
     * Adds images to the given post object
     *
     * @param image the id of the image to be added
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post addImage(Long image, Post post){
        List<Long> imageList = post.getImages();
        imageList.add(image);
        post.setMusic(imageList);
        return post;
    }

    /**
     * Remove images from the given post object
     *
     * @param image the id of the image to be removed
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post removeImage(Long image, Post post){
        List<Long> imageList = post.getImages();
        imageList.remove(image);
        post.setMusic(imageList);
        return post;
    }

    /**
     * Adds audio pieces to the given post object
     *
     * @param audio the id of the audio piece to be added
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post addAudio(Long audio, Post post){
        List<Long> audioList = post.getAudio();
        audioList.add(audio);
        post.setMusic(audioList);
        return post;
    }

    /**
     * Remove audio from the given post object
     *
     * @param audio the id of the audio piece to be removed
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post removeAudio(Long audio, Post post){
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
    public Post like(Long user, Post post){
        List<Long> userList = post.getLikes();
        userList.remove(user);
        post.setMusic(userList);
        return post;
    }

    /**
     * Adds comments to the given post object
     *
     * @param comment the id of the comment to be added
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post addComment(Long comment, Post post){
        List<Long> comments = post.getComments();
        comments.add(comment);
        post.setComments(comments);
        return post;
    }

    /**
     * Remove comments from the given post object
     *
     * @param comment the id of the comment to be removed
     * @param post the given post object
     * @return the updated post
     */
    @Override
    public Post removeComment(Long comment, Post post){
        List<Long> comments = post.getComments();
        comments.remove(comment);
        post.setComments(comments);
        return post;
    }
}
