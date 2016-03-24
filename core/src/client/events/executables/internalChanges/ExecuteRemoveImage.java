package client.events.executables.internalChanges;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 *
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteRemoveImage implements Executable{
    private Image image;
    public ExecuteRemoveImage(Image image){
        this.image = image;
    }

    @Override
    public void execute() {
        image.remove();
    }
}
