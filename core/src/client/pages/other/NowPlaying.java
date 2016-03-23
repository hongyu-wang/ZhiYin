package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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

    State previousState;

    public NowPlaying(State previousState){
        this.previousState = previousState;
        init();
    }

    public void init() {
        super.init();
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());

        float m = StateManager.M;
        slider.setBounds((int)(m*180), (int)(m*400), (int)(m*410), 10);

        stage.addActor(slider);

        Button backButton = new Button(this);
        backButton.setBounds(0 + 1, 1217, 117, 117);
        ExecutableMultiplexer executables = new ExecutableMultiplexer();
        executables.addExecutable(new ExecuteToTempState(previousState));
        backButton.setExecutable(executables);
        add(backButton);

        Button nowPlaying2Button = new Button(this);
        nowPlaying2Button.setBounds(607 + 1, 1063, 51, 51);
        nowPlaying2Button.setExecutable(new ExecuteToTempState(new NowPlaying2(previousState, this)));
        add(nowPlaying2Button);

    }

    @Override
    public void reset() {

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
