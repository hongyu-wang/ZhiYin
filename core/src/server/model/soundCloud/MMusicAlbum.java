package server.model.soundCloud;

import java.util.List;

/**
 * The music album model
 */
public class MMusicAlbum {

    /**
     * List of id's of all the songs the album contains
     */
    private List<Long> songs;

    /**
     * Id of the MText representation of the name of the album
     */
    private long Name;

    /**
     * Id of the MText representation of the description of the album
     */
    private long Description;

    /**
     * Id of the band of the album
     */
    private long band;


    public List<Long> getSongs() {
        return songs;
    }

    public void setSongs(List<Long> songs) {
        this.songs = songs;
    }

    public long getName() {
        return Name;
    }

    public void setName(long name) {
        Name = name;
    }

    public long getDescription() {
        return Description;
    }

    public void setDescription(long description) {
        Description = description;
    }

    public long getBand() {
        return band;
    }

    public void setBand(long band) {
        this.band = band;
    }
}


