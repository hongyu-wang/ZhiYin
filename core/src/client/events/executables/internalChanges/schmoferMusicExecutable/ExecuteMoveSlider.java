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

    public ExecuteMoveSlider(Slider slider) {
        this.slider = slider;
    }

    @Override
    public void execute() {
        if (os == MAC)
            slider.setValue((float)(AudioManager.getTime()/AudioManager.trackLength()*100));



    }
}
