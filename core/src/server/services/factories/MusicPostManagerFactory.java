package server.services.factories;

import server.services.implementations.soundcloudService.MusicPostManagerImplementation;
import server.services.interfaces.models.MusicPostManager;

/**
 * @author rsang
 */
public class MusicPostManagerFactory {

    private static MusicPostManager MusicPostManager;

    public static MusicPostManager createMusicPostManager() {
        if (MusicPostManager == null) {
            MusicPostManager  = new MusicPostManagerImplementation();
        }
        return MusicPostManager;
    }

    private MusicPostManagerFactory(){}

}
