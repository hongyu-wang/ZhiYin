package server.services.factories;

import server.services.implementations.soundcloudService.PlaylistManagerImplementation;
import server.services.interfaces.models.PlaylistManager;

/**
 * @author rsang
 */
public class PlaylistManagerFactory {

    private static PlaylistManager PlaylistManager;

    public static PlaylistManager createPlaylistManager() {
        if (PlaylistManager == null) {
            PlaylistManager  = new PlaylistManagerImplementation();
        }
        return PlaylistManager;
    }

    private PlaylistManagerFactory(){}

}
