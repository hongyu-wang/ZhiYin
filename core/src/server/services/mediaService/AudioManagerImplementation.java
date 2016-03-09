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

        //TODO Implement MAudio.

        //TODO request from server the audio.
        return null;
    }

    public void startRecording() {

    }

    public void playAudio(){

    }

    public MAudio stopRecording() {

    }

    public void playAudio(MAudio audio) {

    }

    public String[] requestAudioInfo() {

    }

}