package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
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

    private boolean save;
    private Friends2 friends2;

    public ExecuteRecord(Friends2 friends2){
        this.friends2 = friends2;
        save = false;
    }


    public void setSave(){
        save = true;
    }



    @Override
    public void execute() {
        AudioPlayer ap = AudioPlayer.getInstance();
        AudioRecorder ar = AudioRecorder.getInstance();
        if(!ar.isRecording()) {

            System.out.println("starting record");
            ar.prepareToRecord();
            ar.startRecording();

        }else {
            System.out.println("done recording");
            MAudio audio = ar.stopRecording();
            if (ap.isPlaying())
                ap.stop();

            if (save){
                ExecutePlayMAudio epma = new ExecutePlayMAudio(audio);
                MessageBox soundbox = new MessageBox(epma, 1);
                friends2.addMessage(soundbox);
                System.out.println("music set");
            }


        }

    }

}
