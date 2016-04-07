package server.services.implementations.mediaService;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;
import server.model.media.MImage;
import server.services.interfaces.models.ImageManager;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kevin Zheng on 2016-03-05.
 */
public class ImageManagerImplementation implements ImageManager {
    private ArrayList<Disposable> disposables = new ArrayList<>();
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
        this.dispose();
        Image tempImage = null;
        if(mImage != null) {
            Texture tx;
            Pixmap pixmap = new Pixmap(mImage.getImage(), 0, mImage.getImage().length);
            tempImage = new Image(tx = new Texture(pixmap));
            disposables.add(tx);
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


    @Override
    public void dispose() {
        for (Disposable i : disposables){
            i.dispose();
        }
    }
}
