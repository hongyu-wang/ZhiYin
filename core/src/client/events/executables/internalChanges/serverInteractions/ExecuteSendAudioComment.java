package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Sec1;
import client.tools.Constants;
import server.model.media.MAudio;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.AudioManagerFactory;
import server.services.factories.CommentManagerFactory;
import tools.AudioTools.AudioRecorder;
import tools.utilities.Utils;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public class ExecuteSendAudioComment implements ExecuteServer {
    private Sec1 sec1;

    public ExecuteSendAudioComment(Sec1 sec1){
        this.sec1 = sec1;
    }

    @Override
    public void execute() {
        MAudio audio;

        if (os == MAC)
            audio = AudioRecorder.getInstance().stopRecording();
        else{
            audio = AudioManagerFactory.createAudioManager().createMockAudio();
        }

        MPost post = sec1.getThisPost();

        List<Long> commentKeys = post.getComments();

        long userKey = localDatabase.getMainUser().getKey();
        User mainUser = localDatabase.getModel(userKey);
        UserProfile userProfile = localDatabase.getModel(mainUser.getProfileKey());

        MComment comment = generateComment(userKey, audio.getKey());

        commentKeys.add(comment.getKey());

        String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());


        sec1.addPost(userProfile.getUsername(), timestamp, audio);
        sec1.getCurrentComments().add(comment.getKey());

        //------------------Pushing.
        List<ServerModel> pushList = Utils.newList();

        pushList.add(comment);
        pushList.add(post);
        pushList.add(audio);

        localDatabase.pushModel(pushList);

    }

    private MComment generateComment(long userKey, long audioKey){
        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.<Long>newList(), Utils.<Long>newList(),
                Utils.<Long>newList(), System.currentTimeMillis(), "", userKey);

        comment.getAudio().add(audioKey);

        comment.setKey(localDatabase.generateKey());

        return comment;
    }

}