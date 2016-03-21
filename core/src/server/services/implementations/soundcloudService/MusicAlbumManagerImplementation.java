package server.services.implementations.soundcloudService;

import server.model.soundCloud.MMusicAlbum;
import server.services.interfaces.models.MusicAlbumManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-10.
 */
public class MusicAlbumManagerImplementation implements MusicAlbumManager {
    /**
     * Creates a new MusicAlbum
     *
     * @param description description of the music album
     * @param name        name of the album
     * @param band        band who made the album
     * @return the new music album
     */
    @Override
    public MMusicAlbum createMusicAlbum(long description, long name, long band) {
        MMusicAlbum newAlbum = new MMusicAlbum();
        newAlbum.setDescription(description);
        newAlbum.setSongs(Utils.<Long>newList());
        newAlbum.setName(name);
        newAlbum.setBand(band);
        return newAlbum;
    }

    /**
     * Edits the description of the album
     *
     * @param description new description
     * @param musicAlbum  the album in question
     * @return the edited album
     */
    @Override
    public MMusicAlbum editDescription(long description, MMusicAlbum musicAlbum) {
        musicAlbum.setDescription(description);
        return musicAlbum;
    }

    /**
     * Edits the name of the music album
     *
     * @param name       new name of the album
     * @param musicAlbum the album in question
     * @return the edited album
     */
    @Override
    public MMusicAlbum editName(long name, MMusicAlbum musicAlbum) {
        musicAlbum.setName(name);
        return musicAlbum;
    }

    /**
     * Adds a song to the album
     *
     * @param song       the id of the song
     * @param musicAlbum the album in question
     * @return the edited album
     */
    @Override
    public MMusicAlbum addSong(long song, MMusicAlbum musicAlbum) {
        List<Long> songs = musicAlbum.getSongs();
        songs.add(song);
        return musicAlbum;
    }

    /**
     * Removes a song from the album
     *
     * @param song       the id of the song
     * @param musicAlbum the album in question
     * @return the edited album
     */
    @Override
    public MMusicAlbum removeSong(long song, MMusicAlbum musicAlbum) {
        List<Long> songs = musicAlbum.getSongs();
        songs.remove(song);
        return musicAlbum;
    }

//    /**
//     * Retrieves an album from the server
//     *
//     * @param key id of the album
//     * @return the associated album
//     */
//    @Override
//    public MMusicAlbum retrieveAlbum(long key) {
//        return null;
//    }
}
