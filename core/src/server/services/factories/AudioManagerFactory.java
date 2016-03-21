package server.services.factories;

import server.services.implementations.mediaService.AudioManagerImplementation;
import server.services.interfaces.models.AudioManager;

/**
 * @author rsang
 */
public class AudioManagerFactory {

    private static AudioManager AudioManager;

    public static AudioManager createAudioManager() {
        if (AudioManager == null) {
            AudioManager  = new AudioManagerImplementation();
        }
        return AudioManager;
    }

    private AudioManagerFactory(){}

}
