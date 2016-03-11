package server.services.soundcloudService;

import server.model.soundCloud.MBand;
import server.services.serviceInterfaces.BandManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-10.
 */
public class BandManagerImplementation implements BandManager {
    /**
     * Creates a new band
     *
     * @param name        id of the name of the band
     * @param description id of the description of the band
     * @return the new band
     */
    public MBand createBand(long name, long description) {
        MBand newBand = new MBand();
        newBand.setName(name);
        newBand.setDescription(description);
        newBand.setSongs(Utils.<Long>newList());
        newBand.setAlbums(Utils.<Long>newList());
        return newBand;
    }

    /**
     * Adds an album to the band
     *
     * @param album id of the new album
     * @param band  the band in question
     * @return the edited band
     */
    public MBand addAlbum(long album, MBand band) {
        List<Long> albumList = band.getAlbums();
        albumList.add(album);
        return band;
    }

    /**
     * Removes an album from the band
     *
     * @param album id of the album to be removed
     * @param band  the band in question
     * @return the edited band
     */
    public MBand removeAlbum(long album, MBand band) {
        List<Long> albumList = band.getAlbums();
        albumList.remove(album);
        return band;
    }

    /**
     * Adds a song to the band
     *
     * @param song id of the song to be added
     * @param band the band in question
     * @return the edited band
     */
    public MBand addSong(long song, MBand band) {
        List<Long> songList = band.getSongs();
        songList.add(song);
        return band;
    }

    /**
     * Removes a song from the band
     *
     * @param song id of the song to be removed
     * @param band the band in question
     * @return the edited band
     */
    public MBand removeSong(long song, MBand band) {
        List<Long> songList = band.getSongs();
        songList.remove(song);
        return band;
    }

    /**
     * Adds an album to the band
     *
     * @param name id of the new name
     * @param band the band in question
     * @return the edited band
     */
    public MBand editName(long name, MBand band) {
        band.setName(name);
        return band;
    }

    /**
     * Edits the description of the band
     *
     * @param description id of the new description
     * @param band        the band in question
     * @return the edited band
     */
    public MBand editDescription(long description, MBand band) {
        band.setDescription(description);
        return band;
    }

    /**
     * Retrieves a band from the server
     *
     * @param band the id of the band
     * @return the associated band
     */
    public MBand retrieveBand(long band) {
        return null;
    }
}
