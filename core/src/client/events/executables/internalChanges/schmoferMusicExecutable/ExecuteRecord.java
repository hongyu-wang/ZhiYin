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


    @Override
    public void execute() {
        if (os == MAC){
            AudioRecorder ar = AudioRecorder.getInstance();
            ar.prepareToRecord();
            ar.startRecording();
        }
    }
}
