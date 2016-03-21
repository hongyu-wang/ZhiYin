package server.services.interfaces.models;

import server.model.media.MAudio;
import server.model.media.MMusic;
import server.webclient.webErrors.WebRequestException;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface MusicManager {

    /**Uploads a piece of music from your phone.
     *
     * @param  audio    The string path to the music.
     * @return          The newly created music.
     */
    MMusic createMusic(MAudio audio) throws WebRequestException;
}
