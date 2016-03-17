package server.services.factories;

import server.services.implementations.mediaService.MusicManagerImplementation;
import server.services.interfaces.models.MusicManager;

/**
 * @author rsang
 */
public class MusicManagerFactory {

    private static MusicManager MusicManager;

    public static MusicManager createMusicManager() {
        if (MusicManager == null) {
            MusicManager  = new MusicManagerImplementation();
        }
        return MusicManager;
    }

    private MusicManagerFactory(){}

}
