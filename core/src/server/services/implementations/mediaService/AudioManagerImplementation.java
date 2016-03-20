package server.services.implementations.mediaService;

import server.model.media.MAudio;
import server.services.interfaces.models.AudioManager;
/**
 * Created by Kevin on 3/6/2016.
 */
public class AudioManagerImplementation implements AudioManager {


    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);

        return audio;
    }

    public MAudio createAudio() {


        return new MAudio();
        //TODO Implement.
    }

}