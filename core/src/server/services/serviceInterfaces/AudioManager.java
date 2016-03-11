package server.services.serviceInterfaces;

import server.model.media.MAudio;

public interface AudioManager {

    public MAudio requestAudio(long key);

    public void createAudio();


}