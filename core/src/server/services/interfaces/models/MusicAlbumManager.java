package server.services.interfaces.models;

import server.model.soundCloud.MMusicAlbum;

/**
 * Created by Hairuo on 2016-03-10.
 */
public interface MusicAlbumManager {

    /**
     * Creates a new MusicAlbum
     *
     * @param description description of the music album
     * @param name        name of the album
     * @param band        band who made the album
     * @return the new music album
     */
    public MMusicAlbum createMusicAlbum(long description, long name, long band);

    /**
     * Edits the description of the album
     *
     * @param description new description
     * @param musicAlbum  the album in question
     * @return the edited album
     */
    public MMusicAlbum editDescription(long description, MMusicAlbum musicAlbum);

    /**
     * Edits the name of the music album
     *
     * @param name       new name of the album
     * @param musicAlbum the album in question
     * @return the edited album
     */
    public MMusicAlbum editName(long name, MMusicAlbum musicAlbum);

    /**
     * Adds a song to the album
     *
     * @param song       the id of the song
     * @param musicAlbum the album in question
     * @return the edited album
     */
    public MMusicAlbum addSong(long song, MMusicAlbum musicAlbum);

    /**
     * Removes a song from the album
     *
     * @param song       the id of the song
     * @param musicAlbum the album in question
     * @return the edited album
     */
    public MMusicAlbum removeSong(long song, MMusicAlbum musicAlbum);
}
