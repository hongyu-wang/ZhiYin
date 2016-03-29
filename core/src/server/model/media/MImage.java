package server.model.media;

import com.badlogic.gdx.graphics.Texture;
import server.model.structureModels.ServerModel;


/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MImage extends ServerModel {
    /**
     * The name of the image.
     */
    String name;
    /**
     * The buffered image.
     */
    byte[] image;

    /**Returns the name or title of this image.
     *
     * @return  The name or title.
     */
    public String getName() {
        return name;
    }

    /**Returns the Texture of the image.
     *
     * @return  The image in a Texture.
     */
    public byte[] getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
