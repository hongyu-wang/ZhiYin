package server.services.serviceInterfaces;

import server.model.media.MMusic;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface MusicManager {

    /**Uploads a piece of music from your phone.
     *
     * @param path  The string path to the music.
     * @return      The newly created music.
     */
    MMusic createMusic(String path) throws IOException;
}
