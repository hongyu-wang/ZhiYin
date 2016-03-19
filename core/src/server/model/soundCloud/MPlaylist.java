package server.model.soundCloud;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public class MPlaylist {

    /**
     * List of id's of all the songs in the playlist
     */
    private List<Long> songs;

    /**
     * Id of the MText representation of the description of the playlist
     */
    private long description;

    public List<Long> getSongs() {
        return songs;
    }

    public void setSongs(List<Long> songs) {
        this.songs = songs;
    }

    public long getDescription() {
        return description;
    }

    public void setDescription(long description) {
        this.description = description;
    }
}
