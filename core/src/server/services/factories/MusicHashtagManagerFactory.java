package server.services.factories;

import server.services.implementations.mediaService.MusicHashtagManagerImplementation;
import server.services.interfaces.models.MusicHashtagManager;


/**
 * @author rsang
 */
public class MusicHashtagManagerFactory {

    private static MusicHashtagManager MusicHashtagManager;

    public static MusicHashtagManager createMusicHashtagManager() {
        if (MusicHashtagManager == null) {
            MusicHashtagManager  = new MusicHashtagManagerImplementation();
        }
        return MusicHashtagManager;
    }

    private MusicHashtagManagerFactory(){}

}
