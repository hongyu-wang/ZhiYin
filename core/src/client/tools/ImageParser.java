package client.tools;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


/**
 *
 * Created by Hongyu Wang on 4/3/2016.
 */
public final class ImageParser {

    private static Image image;


    private static void setUpImage(byte [] bytes){
        Pixmap pixmap = new Pixmap(bytes, 0, bytes.length);
        image = new Image(new Texture(pixmap));
        pixmap.dispose();


    }



    public static Image getImage(){
        if (image == null){
            throw new IllegalStateException();
        }

        return image;
    }



}
