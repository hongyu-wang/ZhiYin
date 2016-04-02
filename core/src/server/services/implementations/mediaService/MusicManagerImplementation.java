package server.services.implementations.mediaService;

import server.model.media.MAudio;
import server.model.media.MMusic;
import server.services.interfaces.models.MusicManager;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class MusicManagerImplementation implements MusicManager {
//    @Override
//    public MMusic requestMusic(long key) {
//        MMusic music = new MMusic();
//        return music;
//    }

    @Override
    public MMusic createMusic(MAudio audio) throws WebRequestException {
        MMusic music = new MMusic();

        music.setKey(WebServiceClient.getSerial());

        music.setMusicKey(audio.getKey());

        return music;
    }
}
