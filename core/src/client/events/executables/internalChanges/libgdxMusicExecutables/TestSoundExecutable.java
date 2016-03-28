package client.events.executables.internalChanges.libgdxMusicExecutables;

import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSErrorException;
import tools.AudioTools.AudioRecorder;

/**
 * A test executable for the record button.
 *
 * Created by Kevin Zheng on 2016-03-14.
 */
public class TestSoundExecutable implements Executable {

    AudioRecorder audRec = AudioRecorder.getInstance();
    /**
     * Starts the recording.
     */
    @Override
    public void execute() {
        try {
            if(!audRec.isRecording()) {
                audRec.prepareToRecord();
                audRec.startRecording();
            }
            else{
                audRec.stopRecording();
            }


        }
        catch(NSErrorException e){
            System.out.println("Recording has failed.");
        }
    }
}
