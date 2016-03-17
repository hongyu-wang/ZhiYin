package client.pages.other;

import client.singletons.StateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends NowPlayingShell {
    private Music music;
    Slider slider;
    private Image buttonAnimation;

    public void init() {
        super.init();

        slider = new Slider(0, 100, 1, false, new Skin(Gdx.files.internal("uiskin.json")));

        slider.getStyle().knob.setMinHeight(10);
        float m = StateManager.M;
        slider.setBounds((int)(m*180), (int)(m*400), (int)(m*410), 10);
        buttonAnimation = new Image("Pause@2x.png");

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
