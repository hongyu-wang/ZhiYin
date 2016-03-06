package server.services.mediaService;

import server.model.media.Image;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class ImageManagerImplementation implements ImageManager {

    @Override
    public Image requestImage(long key) {
        Image image = new Image();
        return image;
        //TODO request from server.
    }


    @Override
    public Image createNewImage(String path) throws IOException {
        Image image = new Image();
        //TODO access phone to create image.
        return image;
    }
}
