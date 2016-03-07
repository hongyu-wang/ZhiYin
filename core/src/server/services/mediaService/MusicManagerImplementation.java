package server.services.mediaService;

import server.model.media.Audio;
import server.model.media.Music;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class MusicManagerImplementation implements MusicManager {
    @Override
    public Music requestMusic(long key) {
        Music music = new Music();
        return music;
        //TODO request from server.
    }

    @Override
    public Music createMusic(String path) throws IOException {
        Music music = new Music();

        long key = 0;
        //TODO Generate key.
        music.setKey(key);

        //TODO implement phone path to create music.
        return music;
    }
}
