package server.services.implementations.mediaService;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import server.model.media.MImage;
import server.services.interfaces.models.ImageManager;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class ImageManagerImplementation implements ImageManager {

//    @Override
//    public MImage requestImage(long key) {
//        MImage image = new MImage();
//        image.setKey(key);
//
//        BufferedImage imageContent = null;
//        image.setImage(imageContent);
//
//        return image;
//    }


    @Override
    public Image mImageToImage(MImage mImage){
        Image tempImage = null;
        if(mImage != null) {
            Pixmap pixmap = new Pixmap(mImage.getImage(), 0, mImage.getImage().length);

            tempImage = new Image(new Texture(pixmap));

            pixmap.dispose();
        }
        return tempImage;
    }

    @Override
    public MImage createNewImage(String path){
        MImage image = new MImage();

        FileHandle fh = Gdx.files.internal(path);

        image.setImage(fh.readBytes());

        return image;
    }
}
