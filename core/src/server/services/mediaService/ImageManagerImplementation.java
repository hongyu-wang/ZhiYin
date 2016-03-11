package server.services.mediaService;

import server.model.media.MImage;
import server.services.serviceInterfaces.ImageManager;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class ImageManagerImplementation implements ImageManager {

    @Override
    public MImage requestImage(long key) {
        MImage image = new MImage();
        image.setKey(key);

        BufferedImage imageContent = null;
        image.setImage(imageContent);

        return image;
        //TODO request from server.
    }


    @Override
    public MImage createNewImage(String path) throws IOException {
        MImage image = new MImage();

        long imageKey = 0;
        //TODO GenerateKey.
        image.setKey(imageKey);
        //TODO Access phone to create image.

        return image;
    }
}
