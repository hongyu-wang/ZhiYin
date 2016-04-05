package server.model.soundCloud;

import server.model.structureModels.ServerModel;

import java.util.List;

/**
 * Band model
 * Contains all albums and songs of the band
 */
public class MBand extends ServerModel {

    /**
     * Id of the MText representation of the name of the band
     */
    private String name;

    /**
     * Id of the MText representation of the description of the band
     */
    private String description;

    /**
     * The image of the band.
     */
    private long bandImage;

    /**
     * List of id's of all the albums that the band has created
     */
    private List<Long> albums;

    /**
     * List of id's of all song's that the band has created
     */
    private List<Long> songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBandImage() {
        return bandImage;
    }

    public void setBandImage(long bandImage) {
        this.bandImage = bandImage;
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
