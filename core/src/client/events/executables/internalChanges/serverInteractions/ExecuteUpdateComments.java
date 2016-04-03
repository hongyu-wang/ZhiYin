package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Comment;
import client.pages.other.Sec1;
import client.tools.Constants;
import server.model.media.MAudio;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateComments extends ExecuteUpdate {

    private Comment commentPage;
    private Sec1 sec1;

    public ExecuteUpdateComments(Comment commentPage, Sec1 sec1){
        this.commentPage = commentPage;
        this.sec1 = sec1;
    }

    @Override
    public void execute() {
        MPost thisPost = localDatabase.getModel(commentPage.getThisPost());

        List<Long> commentKeys = thisPost.getComments();

        for(long key: commentKeys){
            MComment comment = localDatabase.getModel(key);
            User user = localDatabase.getModel(comment.getCreator());
            UserProfile profile = localDatabase.getModel(user.getProfile());

            if(comment.getAudio().size() == 0) {
                if (!commentPage.getCurrentComments().contains(comment.getKey())) {
                    String text = comment.getText();

                    String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());

                    commentPage.addComment(profile.getUsername(), timestamp, text);

                    commentPage.getCurrentComments().add(key);
                }
            }
            else{
                if(!sec1.getCurrentComments().contains(comment.getKey())){
                    MAudio audio = localDatabase.getModel(comment.getAudio().get(0));

                    String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());

                    sec1.addPost(profile.getUsername(), timestamp, audio);

                    sec1.getCurrentComments().add(key);
                }
            }
        }
    }
}
