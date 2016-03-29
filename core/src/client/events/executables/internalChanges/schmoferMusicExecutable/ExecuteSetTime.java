package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import server.model.media.MMusic;
import tools.AudioTools.AudioManager;

/**
 *
 * Created by Hongyu Wang on 3/27/2016.
 */
public class ExecuteSetTime implements Executable{
    private Slider slider;
    public ExecuteSetTime(Slider slider){
        this.slider = slider;
    }


    @Override
    public void execute() {
        System.out.println('a');
        double trackLength = AudioManager.trackLength();
        double percent = slider.getPercent();

        AudioManager.setTime(trackLength * percent);


    }
}
