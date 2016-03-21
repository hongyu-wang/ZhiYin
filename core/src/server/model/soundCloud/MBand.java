package server.model.soundCloud;

import java.util.List;

/**
 * Band model
 * Contains all albums and songs of the band
 */
public class MBand {

    /**
     * Id of the MText representation of the name of the band
     */
    private long name;

    /**
     * Id of the MText representation of the description of the band
     */
    private long description;

    /**
     * List of id's of all the albums that the band has created
     */
    private List<Long> albums;

    /**
     * List of id's of all song's that the band has created
     */
    private List<Long> songs;


    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

    public long getDescription() {
        return description;
    }

    public void setDescription(long description) {
        this.description = description;
    }

    public List<Long> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Long> albums) {
        this.albums = albums;
    }

    public List<Long> getSongs() {
        return songs;
    }

    public void setSongs(List<Long> songs) {
        this.songs = songs;
    }
}
