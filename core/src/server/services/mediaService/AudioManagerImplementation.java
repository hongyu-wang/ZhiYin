package server.services.mediaService;

import server.model.media.MAudio;

/**
 * Created by Kevin on 3/6/2016.
 */
public class AudioManagerImplementation implements AudioManager {

    @Override
    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);

        return audio;
    }

    public void createAudio() {

    }

}