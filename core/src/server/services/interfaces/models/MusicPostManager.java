package server.services.interfaces.models;

import server.model.soundCloud.MMusicPost;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public interface MusicPostManager extends PostManager {

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
    public MMusicPost createPost(List<Long> music, List<Long> images, long timestamp, long text, long band, long genre, long creator);

    /**
     * Changes the genre of the post
     *
     * @param genre new genre
     * @param post  post to be changed
     * @return the edited post
     */
    public MMusicPost changeGenre(long genre, MMusicPost post);

    /**
     * Changes the genre of the post
     *
     * @param band new band
     * @param post post to be changed
     * @return the edited post
     */
    public MMusicPost changeBand(long band, MMusicPost post);


}
