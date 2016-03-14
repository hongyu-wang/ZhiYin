package server.services.interfaces.models;

import server.model.media.MAudio;

public interface AudioManager {
    /**
     * Creates a new audio from Audio Tools.
     *
     * @return
     */
    public MAudio createAudio();
}