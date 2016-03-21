package server.services.factories;

import server.services.implementations.mediaService.TextManagerImplementation;
import server.services.interfaces.models.TextManager;

/**
 * @author rsang
 */
public class TextManagerFactory {

    private static TextManager TextManager;

    public static TextManager createTextManager() {
        if (TextManager == null) {
            TextManager  = new TextManagerImplementation();
        }
        return TextManager;
    }

    private TextManagerFactory(){}

}
