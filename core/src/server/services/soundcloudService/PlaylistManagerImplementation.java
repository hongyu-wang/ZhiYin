package server.services.soundcloudService;

import server.model.media.MText;
import server.model.soundCloud.MPlaylist;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public class PlaylistManagerImplementation {

    /**
     * retrieves a playlist from the server
     *
     * @param key id of the playlist
     * @return the associated playlist
     */
    public MPlaylist getPlaylist(long key){
        return null;
    }

    /**
     * Create a new playlist
     *
     * @param description description of the playlist
     * @return new playlist
     */
    public MPlaylist createPlaylist(long description){
        MPlaylist newPlaylist = new MPlaylist();
        newPlaylist.setDescription(description);
        newPlaylist.setSongs(Utils.<Long>newList());
        return newPlaylist;
    }

    /**
     * Adds to the playlist
     *
     * @param song song to be added
     * @param playlist playlist to be added to
     * @return new playlist
     */
    public MPlaylist addTo(long song, MPlaylist playlist){
        List<Long> songs  = playlist.getSongs();
        songs.add(song);
        return  playlist;
    }

    /**
     * Removes from the playlist
     *
     * @param song song to be removed
     * @param playlist playlist to be removed from
     * @return new playlist
     */
    public MPlaylist removeTo(long song, MPlaylist playlist){
        List<Long> songs  = playlist.getSongs();
        songs.remove(song);
        return  playlist;
    }

}

