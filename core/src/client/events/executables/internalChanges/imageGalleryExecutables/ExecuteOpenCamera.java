package client.events.executables.internalChanges.imageGalleryExecutables;

import client.stateInterfaces.Executable;
import tools.imageTools.Controller;

/**
 * Created by kevin on 2016-04-03.
 */
public class ExecuteOpenCamera implements Executable {
    @Override
    public void execute() {
        Controller.getInstance().openCamera();
    }
}
