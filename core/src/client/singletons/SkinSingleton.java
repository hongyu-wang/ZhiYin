package client.singletons;

import client.tools.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class SkinSingleton {
    private static Skin ourInstance;

    public static Skin getInstance(){


        if (ourInstance == null){
            String filepath = Constants.M == 0.5F ? "SkinAssets1" : "SkinAssets2";

            ourInstance = new Skin(Gdx.files.internal(filepath + "/uiskin.json"));
            if (Constants.M > 1) {
                for (String name : ourInstance.getAll(BitmapFont.class).keys()) {
                    ourInstance.getFont(name).getData().setScale(Constants.M, Constants.M);
                }
            }
        }

        return ourInstance;
    }


}
