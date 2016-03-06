package server.services.mediaService;

import server.model.media.Image;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public interface ImageManager {
    /**Request the image from the server based on a key.
     *
     */

    Image requestImage(long key);

    /**Creates a new image based on images stored on the phone.
     *
     * @param path  The string path to the image.
     * @return      The Image created from the path.
     */
    Image createNewImage(String path) throws IOException;
}
