package client.tools;


import client.internalExceptions.NoImageException;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;


/**
 *
 * Created by Hongyu Wang on 4/3/2016.
 */
public final class ImageParser {

    private static Image image;
    private static ArrayList<Disposable> arrayList = new ArrayList<>();
    public static void setUpImage(byte [] bytes, boolean cancelled){
        if(cancelled)
            image = null;
        else {
            Texture tx;
            Pixmap pixmap = new Pixmap(bytes, 0, bytes.length);
            image = new Image(tx = new Texture(pixmap));
            arrayList.add(tx);
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
        for (Disposable i : arrayList){
            i.dispose();
        }
    }


}
