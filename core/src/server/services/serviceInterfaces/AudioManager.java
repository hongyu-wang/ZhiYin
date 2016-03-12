package server.services.serviceInterfaces;

import server.model.media.MAudio;

public interface AudioManager {
    /**
     * Creates a new audio from Audio Tools.
     *
     * @return
     */
    public MAudio createAudio();
}