package server.services.interfaces.models;

import server.model.media.MAudio;
import server.webclient.webErrors.WebRequestException;

public interface AudioManager {
    /**
     * Creates a new audio from Audio Tools.
     *
     * @return
     */
    public MAudio createAudio(String path) throws WebRequestException;
}