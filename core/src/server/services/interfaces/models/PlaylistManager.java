package server.services.interfaces.models;

import server.model.soundCloud.MPlaylist;

/**
 * Created by Hairuo on 2016-03-09.
 */
public interface PlaylistManager {

    /**
     * Create a new playlist
     *
     * @param description description of the playlist
     * @return new playlist
     */
    public MPlaylist createPlaylist(long description);

    /**
     * Adds to the playlist
     *
     * @param song song to be added
     * @param playlist playlist to be added to
     * @return new playlist
     */
    public MPlaylist addTo(long song, MPlaylist playlist);

    /**
     * Removes from the playlist
     *
     * @param song song to be removed
     * @param playlist playlist to be removed from
     * @return new playlist
     */
    public MPlaylist removeTo(long song, MPlaylist playlist);


}
