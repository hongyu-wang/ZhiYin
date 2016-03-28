package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.libgdxMusicExecutables.ExecutePauseMusic;
import client.events.executables.internalChanges.libgdxMusicExecutables.ExecutePlayMusic;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteMoveSlider;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import static client.singletons.StateManager.M;
/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Picture co-ords: TopLeft: 49, 193
 *                  BottomRight:  706, 847
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends NowPlayingShell {
    private Music music;
    private Slider slider;

    private State previousState;

    public NowPlaying(State previousState, Music music){
        this.previousState = previousState;
        this.music = music;
        init();
    }

    @Override
    public void init() {
        super.init();


        addBackButton();
        addPlayButton();

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

    @Override
    public void update(float dt){
        super.update(dt);
    }

    public void intializeSlider(){
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());
        slider.setBounds((int) (M * 180), (int) (M * 400), (int) (M * 410), 10);
        slider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {


            }
        });
        stage.addActor(slider);
    }


    private void addBackButton(){
        Button backButton = new Button(this);
        backButton.setBounds(0 + 1, 1217, 117, 117);
        ExecutableMultiplexer executables = new ExecutableMultiplexer();
        executables.addExecutable(new ExecuteToTempState(previousState));
        executables.addExecutable(new ExecutePauseMusic(music));
        backButton.setExecutable(executables);
        add(backButton);
    }

    private void addPlayButton(){
        Button pauseButton = new Button(this);
        pauseButton.setBounds(288 + 1, 177, 180, 180);
        pauseButton.setExecutable(new ExecutePlayMusic(music));
        add(pauseButton);
    }





    public Music getMusic() {

        return music;
    }

    public void setMusic(String trackName) {
        this.music = Gdx.audio.newMusic(Gdx.files.internal(trackName));

    }


}
