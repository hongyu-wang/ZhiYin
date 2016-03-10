package server.services.mediaService;

import server.model.media.MAudio;

public interface AudioManager {

    void startRecording();

    MAudio stopRecording();

    void playAudio();

    String[] requestAudioInfo();

    public MAudio requestAudio(long key);


}