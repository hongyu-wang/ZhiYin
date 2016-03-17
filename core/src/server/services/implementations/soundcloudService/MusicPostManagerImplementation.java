package server.services.implementations.soundcloudService;


import server.model.soundCloud.MMusicPost;
import server.services.interfaces.models.MusicPostManager;
import server.services.implementations.socialService.PostManagerImplementation;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public class MusicPostManagerImplementation extends PostManagerImplementation implements MusicPostManager {

    /**
     * Create a new Music Post
     *
     * @param music     music piece that the post contains
     * @param images    images that the post contains
     * @param timestamp when the post was created
     * @param text      description of the piece of music
     * @param band      band of the musicians
     * @param genre     genre of the music
     * @param creator   creator of the post
     * @return
     */
    @Override
    public MMusicPost createPost(List<Long> music, List<Long> images, long timestamp, long text, long band, long genre, long creator) {
        MMusicPost post = new MMusicPost();
        post.setMusic(music);
        post.setImages(images);
        post.setComments(Utils.<Long>newList());
        post.setTimeStamp(timestamp);
        post.setText(text);
        post.setCreator(creator);
        post.setBand(band);
        post.setGenre(genre);
        return post;

    }


    /**
     * Changes the genre of the post
     *
     * @param genre new genre
     * @param post  post to be changed
     * @return the edited post
     */
    @Override
    public MMusicPost changeGenre(long genre, MMusicPost post) {
        post.setGenre(genre);
        return post;
    }

    /**
     * Changes the genre of the post
     *
     * @param band new band
     * @param post post to be changed
     * @return the edited post
     */
    @Override
    public MMusicPost changeBand(long band, MMusicPost post) {
        post.setBand(band);
        return post;
    }
}

