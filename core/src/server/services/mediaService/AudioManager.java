package server.services.mediaService;

import server.model.media.Audio;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface AudioManager {

    void startRecording();

    Audio stopRecording();

    void playAudio();

    String[] requestAudioInfo();



}
