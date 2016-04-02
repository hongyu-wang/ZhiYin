package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.other.NowPlaying;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import tools.AudioTools.AudioManager;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecuteMoveSlider implements Executable{
    private Slider slider;
    private NowPlaying nowPlaying;

    public ExecuteMoveSlider(Slider slider, NowPlaying nowPlaying) {
        this.slider = slider;
        this.nowPlaying = nowPlaying;
    }

    @Override
    public void execute() {

        slider.setValue((float)(AudioManager.getTime()/AudioManager.trackLength()*100));



    }
}
