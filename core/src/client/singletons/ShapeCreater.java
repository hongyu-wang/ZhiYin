package client.singletons;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * This is the ShapeRenderer singleton instance.
 * The primary use of this is so that it is no longer required to continuously
 * generate these whenever you want to draw a shape.
 *
 * Created by Hongyu Wang on 3/12/2016.
 */
public class ShapeCreater {
    private static ShapeRenderer ourInstance = new ShapeRenderer();

    public static ShapeRenderer getInstance() {
        return ourInstance;
    }


}
