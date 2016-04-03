package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Comment;
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
public class ExecuteSendComment implements ExecuteServer {
    private Comment commentPage;
    public ExecuteSendComment(Comment commentPage){
        this.commentPage = commentPage;
    }


    @Override
    public void execute() {

        MPost post = commentPage.getThisPost();

        List<Long> commentKeys = post.getComments();

        String userText = commentPage.getMessage();

        long userKey = localDatabase.getMainUser().getKey();
        User mainUser = localDatabase.getModel(userKey);
        UserProfile userProfile = localDatabase.getModel(mainUser.getProfile());

        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.<Long>newList(), Utils.<Long>newList(),
                Utils.<Long>newList(), System.currentTimeMillis(), userText, userKey);
        comment.setKey(localDatabase.generateKey());

        commentKeys.add(comment.getKey());

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm");
        Date df = new Date(comment.getTimeStamp());
        String timestamp = sdf.format(df);

        commentPage.addComment(userProfile.getUsername(), timestamp, userText);
        commentPage.reset();
        commentPage.getCurrentComments().add(comment.getKey());

        localDatabase.pushModel(comment);
        localDatabase.pushModel(post);
    }
}
