package server.services.mediaService;

import server.model.media.Music;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface MusicManager {
    /**Requests a piece of music from the server.
     *
     * @param key   The string identifying of the music.
     * @return      The new Music piece.
     */
    Music requestMusic(String key);

    /**Uploads a piece of music from your phone.
     *
     * @param path  The string path to the music.
     * @return      The newly created music.
     */
    Music createMusic(String path) throws IOException;
}
