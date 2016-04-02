package client.events.executables.internalChanges.conversation;

import client.pages.other.Comment;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.CommentManagerFactory;
import tools.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-29.
 */
public class ExecuteSendComment implements Executable {
    private Comment commentPage;
    public ExecuteSendComment(Comment commentPage){
        this.commentPage = commentPage;
    }


    @Override
    public void execute() {

        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MPost post = commentPage.getThisPost();

        List<Long> commentKeys = post.getComments();

        String userText = commentPage.getMessage();

        long userKey = ms.getMainUser().getKey();
        User mainUser = ms.getModel(userKey);
        UserProfile userProfile = ms.getModel(mainUser.getProfile());

        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.<Long>newList(), Utils.<Long>newList(),
                Utils.<Long>newList(), System.currentTimeMillis(), userText, userKey);
        comment.setKey(ms.generateKey());

        commentKeys.add(comment.getKey());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date df = new Date(comment.getTimeStamp());
        String timestamp = sdf.format(df);

        commentPage.addComment(userProfile.getUsername(), timestamp, userText);

        commentPage.getCurrentComments().add(comment.getKey());

        ms.pushModel(comment);
        ms.pushModel(post);
    }
}
