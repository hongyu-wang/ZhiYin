package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioPlayer;
import tools.AudioTools.AudioRecorder;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteRecord implements Executable {

    private ModelStorage ms;
    private boolean save;
    private Friends2 friends2;


    public ExecuteRecord(Friends2 friends2){
        ms = ModelStorageFactory.createModelStorage();
        this.friends2 = friends2;
        save = false;
    }

    public void setSave(){
        save = true;
    }

    @Override
    public void execute() {
        AudioRecorder ar = AudioRecorder.getInstance();

        if(!ar.isRecording()) {

            System.out.println("starting record");
            ar.prepareToRecord();
            ar.startRecording();

        }else {
            System.out.println("done recording");
            MAudio audio = ar.stopRecording();
            ms.pushModel(audio);
            System.out.println(audio.getKey());

            if (save){
                ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                MessageBox soundbox = new MessageBox(epma, 1, audio);
                friends2.addMessage(soundbox);
                System.out.println("music set");

            }


        }

    }

}
