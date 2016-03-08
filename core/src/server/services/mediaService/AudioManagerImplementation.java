package server.services.mediaService;

import server.model.media.MAudio;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public class AudioManagerImplementation implements AudioManager{

    void startRecording(){

    }

    MAudio stopRecording(){

    };

    void playAudio(){

    };

    String[] requestAudioInfo(){

    };


    public MAudio requestAudio(long key) {
        MAudio audio = new MAudio();
        audio.setKey(key);
    }

}