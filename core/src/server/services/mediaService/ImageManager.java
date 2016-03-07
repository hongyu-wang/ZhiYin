package server.services.mediaService;

import server.model.media.MImage;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface ImageManager {
    /**Request the image from the server based on a key.
     *
     */

    MImage requestImage(long key);

    /**Creates a new image based on images stored on the phone.
     *
     * @param path  The string path to the image.
     * @return      The MImage created from the path.
     */
    MImage createNewImage(String path) throws IOException;
}
