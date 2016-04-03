package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Sec1;
import server.model.media.MAudio;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.CommentManagerFactory;
import tools.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        MPost post = sec1.getThisPost();

        List<Long> commentKeys = post.getComments();

        long userKey = localDatabase.getMainUser().getKey();
        User mainUser = localDatabase.getModel(userKey);
        UserProfile userProfile = localDatabase.getModel(mainUser.getProfile());

        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.<Long>newList(), Utils.<Long>newList(),
                Utils.<Long>newList(), System.currentTimeMillis(), "", userKey);
        comment.setKey(localDatabase.generateKey());

        commentKeys.add(comment.getKey());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date df = new Date(comment.getTimeStamp());
        String timestamp = sdf.format(df);

        sec1.addPost(userProfile.getUsername(), timestamp, null);

        sec1.getCurrentComments().add(comment.getKey());

        //TODO change it to add music;

        ServerModel[] pushList = {
                comment,
                post
        };

        localDatabase.pushModel(pushList);
    }
}
