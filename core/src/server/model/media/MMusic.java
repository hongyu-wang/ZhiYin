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
    /**
     * The key to the audio.
     */
    long audioKey;

    long albumArt;

    String album;

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

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }


    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }


    public long getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(long albumArt) {
        this.albumArt = albumArt;
    }

}

