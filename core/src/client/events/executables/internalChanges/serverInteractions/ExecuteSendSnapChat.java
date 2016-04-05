package client.events.executables.internalChanges.serverInteractions;

import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteStopSnapChat;
import client.pages.other.NowPlaying;
import server.model.media.MAudio;
import server.model.media.MSnapShot;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import tools.AudioTools.AudioCreator;
import tools.AudioTools.AudioPlayer;
import tools.AudioTools.AudioRecorder;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecuteSendSnapChat implements ExecuteServer {
    public static double[] time;

    private String friendName;

    public ExecuteSendSnapChat(String friendName){
        this.friendName = friendName;
    }

    @Override
    public void execute() {
        AudioPlayer audioPlayer = AudioPlayer.getInstance();
        AudioRecorder audioRecorder = AudioRecorder.getInstance();

        MAudio song = audioPlayer.getCurrentAudio();
        MAudio userRecording = audioRecorder.stopRecording();

        MSnapShot snapShot = getSnapshot(localDatabase.getMainUser(), song, userRecording);

        User friend = localDatabase.getModel(localDatabase.getUserKeyByName(friendName));
        friend.setSnapChat(snapShot.getKey());

        List<ServerModel> pushList = Utils.newList();
        pushList.add(friend);
        pushList.add(snapShot);
        pushList.add(userRecording);
        localDatabase.pushModel(pushList);
    }

    private MSnapShot getSnapshot(User user, MAudio song, MAudio userRecording){

        MSnapShot snapShot = AudioCreator.createSnapShot(userRecording.getKey(), song.getKey(), (int)time[0], (int)time[1]);
        snapShot.setKey(localDatabase.generateKey());
        snapShot.setCreator(user.getKey());



        return snapShot;
    }

}
