package server.services.mediaService;

import server.model.media.MAudio;

/**
 * Created by Kevin Zheng on 2016-03-07.
 */
public class AudioManagerImplementation implements AudioManager{
    @Override
    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);

        //TODO Implement MAudio.

        //TODO request from server the audio.
        return null;
    }
}
