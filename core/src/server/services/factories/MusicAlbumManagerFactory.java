package server.services.factories;

import server.services.implementations.soundcloudService.MusicAlbumManagerImplementation;
import server.services.interfaces.models.MusicAlbumManager;

/**
 * @author rsang
 */
public class MusicAlbumManagerFactory {

    private static MusicAlbumManager MusicAlbumManager;

    public static MusicAlbumManager createMusicAlbumManager() {
        if (MusicAlbumManager == null) {
            MusicAlbumManager  = new MusicAlbumManagerImplementation();
        }
        return MusicAlbumManager;
    }

    private MusicAlbumManagerFactory(){}

}
