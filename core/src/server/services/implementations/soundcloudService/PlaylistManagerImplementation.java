package server.services.implementations.soundcloudService;

import server.model.soundCloud.MPlaylist;
import server.services.interfaces.models.PlaylistManager;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Hairuo on 2016-03-09.
 */
public class PlaylistManagerImplementation implements PlaylistManager{
//
//    /**
//     * retrieves a playlist from the server
//     *
//     * @param key id of the playlist
//     * @return the associated playlist
//     */
//    @Override
//    public MPlaylist getPlaylist(long key){
//        return null;
//    }

    /**
     * Create a new playlist
     *
     * @param description description of the playlist
     * @return new playlist
     */
    @Override
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
    @Override
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
    @Override
    public MPlaylist removeTo(long song, MPlaylist playlist){
        List<Long> songs  = playlist.getSongs();
        songs.remove(song);
        return  playlist;
    }

}

