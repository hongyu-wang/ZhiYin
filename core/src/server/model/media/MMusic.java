package server.model.media;

import server.model.structureModels.ServerModel;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMusic extends ServerModel {
    /**
     * The name of the music.
     */
    String name;

    String artist;
    /**
     * The key to the audio.
     */
    long audioKey;

    /**
     * Returns the title of the music.
     *
     * @return The title string.
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the audio which represents the music file.
     *
     * @return The audio file.
     */
    public long getMusicKey() {
        return audioKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMusicKey(long audioKey) {
        this.audioKey = audioKey;
    }

}

