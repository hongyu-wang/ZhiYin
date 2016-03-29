package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ZhiYinRealChangeListener;
import tools.AudioTools.AudioManager;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecuteMoveSlider implements Executable{
    private Slider slider;
    private ZhiYinRealChangeListener zrcl;
    public ExecuteMoveSlider(Slider slider, ZhiYinRealChangeListener zrcl){
        this.slider = slider;
        this.zrcl = zrcl;
    }

    @Override
    public void execute() {
        slider.setValue((float)(AudioManager.getTime()/AudioManager.trackLength()*100));
        zrcl.setChange();

    }
}
