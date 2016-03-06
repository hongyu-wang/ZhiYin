package server.model.media;

import java.awt.image.BufferedImage;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Image{
    String name;
    BufferedImage image;

    /**Returns the name or title of this image.
     *
     * @return  The name or title.
     */
    public String getName() {
        return name;
    }

    /**Returns the BufferedImage of the image.
     *
     * @return  The image in a BufferedImage.
     */
    public BufferedImage getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
