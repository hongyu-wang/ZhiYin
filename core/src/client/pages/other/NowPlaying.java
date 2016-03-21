package client.pages.other;

import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends NowPlayingShell {
    private Music music;
    Slider slider;

    public void init() {
        super.init();
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());

        float m = StateManager.M;
        slider.setBounds((int)(m*180), (int)(m*400), (int)(m*410), 10);

        stage.addActor(slider);

    }

    @Override
    public void dispose() {


    }


    public void update(float dt){
        super.update(dt);
    }


    public Music getMusic() {

        return music;
    }

    public void setMusic(String trackName) {
        this.music = Gdx.audio.newMusic(Gdx.files.internal(trackName));

    }
}
