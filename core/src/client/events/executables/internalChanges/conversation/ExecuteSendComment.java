package client.events.executables.internalChanges.conversation;

import client.pages.friends.boxes.MessageBox;
import client.pages.other.Comment;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.stateInterfaces.Executable;
import server.model.media.MText;
import server.model.social.MComment;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.CommentManagerFactory;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;
import tools.utilities.Utils;

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

        MText text = TextManagerFactory.createTextManager().createText(userText, 0);

        long userKey = ms.getMainUser().getKey();
        User mainUser = ms.getModel(userKey);
        UserProfile userProfile = ms.getModel(mainUser.getProfile());

        MComment comment = CommentManagerFactory.createCommentManager().createComment(Utils.newList(), Utils.newList(),
                Utils.newList(), System.currentTimeMillis(), userText, userKey);

        commentKeys.add(comment.getKey());

        commentPage.addComment(userProfile.getUsername(), ""+System.currentTimeMillis(), userText);

        commentKeys.add(comment.getKey());

        ms.pushModel(text);
        ms.pushModel(comment);
        ms.pushModel(post);
    }
}
