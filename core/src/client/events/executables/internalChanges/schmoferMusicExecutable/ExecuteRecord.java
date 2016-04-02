package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.LocalDatabase;
import client.pages.pageInternal.modelStorage.LocalDatabaseFactory;
import client.stateInterfaces.Executable;
import server.model.media.MAudio;
import tools.AudioTools.AudioRecorder;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteRecord implements Executable {
    private static boolean RECORD = false;
    private LocalDatabase localDatabase;
    private boolean save;
    private Friends2 friends2;


    public ExecuteRecord(Friends2 friends2){
        localDatabase = LocalDatabaseFactory.createModelStorage();
        this.friends2 = friends2;
        save = false;
    }

    public void setSave(){
        save = true;
    }

    @Override
    public void execute() {
        if (RECORD) {
            AudioRecorder ar = AudioRecorder.getInstance();

            if (!ar.isRecording()) {

                System.out.println("starting record");
                ar.prepareToRecord();
                ar.startRecording();

            } else {
                System.out.println("done recording");
                MAudio audio = ar.stopRecording();
                localDatabase.pushModel(audio);
                System.out.println(audio.getKey());

                if (save) {
                    ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                    MessageBox soundbox = new MessageBox(epma, 1, audio);
                    friends2.addMessage(soundbox);
                    System.out.println("music set");

                }


            }
        }

    }

}
