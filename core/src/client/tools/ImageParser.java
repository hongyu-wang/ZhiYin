package client.tools;


import client.internalExceptions.NoImageException;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;


/**
 *
 * Created by Hongyu Wang on 4/3/2016.
 */
public final class ImageParser {

    private static Image image;
    private static Texture tx;
    public static void setUpImage(byte [] bytes, boolean cancelled){
        if(cancelled)
            image = null;
        else {

            Pixmap pixmap = new Pixmap(bytes, 0, bytes.length);
            image = new Image(tx = new Texture(pixmap));
            pixmap.dispose();
        }

    }



    public static Image getImage() throws IllegalStateException{
        if (image == null){
            throw new IllegalStateException();
        }

        return image;
    }

    public static void dispose(){
        tx.dispose();
    }


}
