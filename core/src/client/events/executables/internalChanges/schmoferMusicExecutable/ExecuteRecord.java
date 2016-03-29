package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.stateInterfaces.Executable;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSErrorException;
import server.model.media.MAudio;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioRecorder;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteRecord implements Executable {

    private boolean save;
    private Friends2 friends2;

    public ExecuteRecord(boolean save, Friends2 friends2){
        this.save = save;
    }


    @Override
    public void execute() {

        AudioRecorder ar = AudioRecorder.getInstance();
        if(!ar.isRecording()) {
            try {
                ar.prepareToRecord();
                ar.startRecording();
            } catch (NSErrorException e) {
                e.printStackTrace();
            }

        }else{
            MAudio audio = ar.stopRecording();
            if (save){
                ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                MessageBox soundbox = new MessageBox(epma, 1);
                friends2.addMessage(soundbox);
            }


        }

    }

}
