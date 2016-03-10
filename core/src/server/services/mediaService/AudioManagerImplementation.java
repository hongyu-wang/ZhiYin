package server.services.mediaService;

import server.model.media.Audio;
import server.model.media.MAudio;

/**
 * Created by Kevin on 3/6/2016.
 */
public class AudioManagerImplementation implements AudioManager {

    @Override
    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);

        //TODO Implement MAudio.

        //TODO request from server the audio.
        return null;
    }

    public void startRecording() {

    }

    public Audio stopRecording() {

    }

    public void playAudio(Audio audio) {

    }

    public String[] requestAudioInfo() {

    }

}