package server.services.mediaService;

import server.model.media.MAudio;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface AudioManager {
    //TODO KK audio design.

    /**Returns the requested MAudio based on a key.
     *
     * @param key   The key long.
     * @return      The requested Audio.
     */
    MAudio requestAudio(long key);
}
