package server.model.media;

import server.model.soundCloud.MMusicPost;

/**
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MMusic extends MMusicPost {
    /**
     * The name of the music.
     */
    String name;

    String artist;

    public long getMusicKey() {
        return musicKey;
    }

    public void setMusicKey(long musicKey) {
        this.musicKey = musicKey;
    }

    /**
     * The key to the audio.
     */
    long musicKey;

    long albumArt;

    String album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(long albumArt) {
        this.albumArt = albumArt;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}

