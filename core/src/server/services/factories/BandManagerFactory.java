package server.services.factories;

import server.services.implementations.soundcloudService.BandManagerImplementation;
import server.services.interfaces.models.BandManager;

/**
 * @author rsang
 */
public class BandManagerFactory {

    private static BandManager BandManager;

    public static BandManager createBandManager() {
        if (BandManager == null) {
            BandManager  = new BandManagerImplementation();
        }
        return BandManager;
    }

    private BandManagerFactory(){}

}
