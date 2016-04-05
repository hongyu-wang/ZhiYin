package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Comment;
import client.tools.Constants;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.CommentManagerFactory;
import tools.utilities.Utils;

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
        MPost post = localDatabase.getModel(commentPage.getThisPost());

        List<Long> commentKeys = post.getComments();

        String userText = commentPage.getMessage();

        long userKey = localDatabase.getMainUser().getKey();
        User mainUser = localDatabase.getModel(userKey);
        UserProfile userProfile = localDatabase.getModel(mainUser.getProfileKey());

        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.<Long>newList(), Utils.<Long>newList(),
                Utils.<Long>newList(), System.currentTimeMillis(), userText, userKey);
        comment.setKey(localDatabase.generateKey());

        commentKeys.add(comment.getKey());

        String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());

        commentPage.addComment(userProfile.getUsername(), timestamp, userText);
        commentPage.getCurrentComments().add(comment.getKey());
        commentPage.reset();

        //------------------Pushing---
        List<ServerModel> pushList = Utils.newList();

        pushList.add(comment);
        pushList.add(post);

        localDatabase.pushModel(pushList);
    }
}
