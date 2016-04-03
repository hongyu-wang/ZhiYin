package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import tools.AudioTools.AudioRecorder;

/**
 *
 * Created by Hongyu Wang on 4/2/2016.
 */
public class ExecuteCancelRecording implements Executable {
    @Override
    public void execute() {
        if (os == MAC) {
            AudioRecorder ar = AudioRecorder.getInstance();
            ar.stopRecording();
        }
    }
}
