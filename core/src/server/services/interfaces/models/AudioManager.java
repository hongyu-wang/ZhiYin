package server.services.interfaces.models;

import server.model.media.MAudio;
import server.webclient.webErrors.WebRequestException;

public interface AudioManager {
    /**
     * Creates a new audio from Audio MyProfile.
     *
     * @return
     */
    MAudio createAudio(String path) throws WebRequestException;
    MAudio createMockAudio();
}