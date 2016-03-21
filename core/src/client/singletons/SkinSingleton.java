package client.singletons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class SkinSingleton {
    private static Skin ourInstance;

    public static Skin getInstance(){
        if (ourInstance == null){
            ourInstance = new Skin(Gdx.files.internal("SkinAssets1\\uiskin.json"));
        }

        return ourInstance;
    }


}
