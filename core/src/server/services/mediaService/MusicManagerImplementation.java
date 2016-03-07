package server.services.mediaService;

import server.model.media.MMusic;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class MusicManagerImplementation implements MusicManager {
    @Override
    public MMusic requestMusic(long key) {
        MMusic music = new MMusic();
        return music;
        //TODO request from server.
    }

    @Override
    public MMusic createMusic(String path) throws IOException {
        MMusic music = new MMusic();

        long key = 0;
        //TODO Generate key.
        music.setKey(key);

        //TODO implement phone path to create music.
        return music;
    }
}
