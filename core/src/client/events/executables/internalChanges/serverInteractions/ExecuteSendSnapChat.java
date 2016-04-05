package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.NowPlaying;
import server.model.media.MAudio;
import server.model.media.MSnapShot;
import server.model.structureModels.ServerModel;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioPlayer;
import tools.AudioTools.AudioRecorder;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteSendSnapChat implements ExecuteServer {

    public ExecuteSendSnapChat(){
    }

    @Override
    public void execute() {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        AudioRecorder audioRecorder = AudioRecorder.getInstance();

        MAudio song = audioPlayer.getCurrentAudio();
        double[] time = audioPlayer.stopSnapChatTime();
        MAudio userRecording = audioRecorder.stopRecording();

        MSnapShot snapShot = AudioCreator.createSnapShot(userRecording.getKey(), song.getKey(), (int)time[0], (int)time[1]);
        snapShot.setKey(localDatabase.generateKey());

        List<ServerModel> pushList = Utils.newList();
        pushList.add(snapShot);
        localDatabase.pushModel(pushList);
    }
}
