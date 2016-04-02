package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pageStorage.Pages;
import client.pages.State;
import client.pages.friends.boxes.MessageBox;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import tools.AudioTools.AudioRecorder;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteRecord implements Executable {
    private AudioRecorder ar;

    public ExecuteRecord(){
        ar = AudioRecorder.getInstance();
    }

    @Override
    public void execute() {

        ar.prepareToRecord();
        ar.startRecording();

    }
}
