package server.services.factories;

import server.services.implementations.mediaService.ImageManagerImplementation;
import server.services.interfaces.models.ImageManager;


/**
 * @author rsang
 */
public class ImageManagerFactory {

    private static ImageManager ImageManager;

    public static ImageManager createImageManager() {
        if (ImageManager == null) {
            ImageManager  = new ImageManagerImplementation();
        }
        return ImageManager;
    }

    private ImageManagerFactory(){}

}
