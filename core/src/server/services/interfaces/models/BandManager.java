package server.services.interfaces.models;

import server.model.soundCloud.MBand;

/**
 * Edits and Creates Bands
 */
public interface BandManager {

    /**
     * Creates a new band
     *
     * @param name        id of the name of the band
     * @param description id of the description of the band
     * @return the new band
     */
    public MBand createBand(String name, String description);

    /**
     * Adds an album to the band
     *
     * @param album id of the new album
     * @param band  the band in question
     * @return the edited band
     */
    public MBand addAlbum(long album, MBand band);

    /**
     * Removes an album from the band
     *
     * @param album id of the album to be removed
     * @param band  the band in question
     * @return the edited band
     */
    public MBand removeAlbum(long album, MBand band);

    /**
     * Adds a song to the band
     *
     * @param song id of the song to be added
     * @param band the band in question
     * @return the edited band
     */
    public MBand addSong(long song, MBand band);

    /**
     * Removes a song from the band
     *
     * @param song id of the song to be removed
     * @param band the band in question
     * @return the edited band
     */
    public MBand removeSong(long song, MBand band);

    /**
     * Adds an album to the band
     *
     * @param name id of the new name
     * @param band the band in question
     * @return the edited band
     */
    public MBand editName(String name, MBand band);

    /**
     * Edits the description of the band
     *
     * @param description id of the new description
     * @param band        the band in question
     * @return the edited band
     */
    public MBand editDescription(String description, MBand band);
}
