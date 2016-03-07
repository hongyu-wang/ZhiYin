package client;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * This is the Singleton SpriteBatch instance.
 * Every component and page sould use this instance of SpriteBatch.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class MainBatch {

    /**
     * The instance of the SpriteBatch.
     */
    private static SpriteBatch ourInstance = new SpriteBatch();

    /**
     * This will return our instance of SpriteBatch
     * @return the SpriteBatch instance that we use.
     */
    public static SpriteBatch getInstance() {
        return ourInstance;
    }
}
