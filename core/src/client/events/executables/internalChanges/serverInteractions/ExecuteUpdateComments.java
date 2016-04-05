package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.Comment;
import client.pages.other.Sec1;
import client.tools.Constants;
import server.model.media.MAudio;
import server.model.social.MComment;
import server.model.social.MPost;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.util.Collections;
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
        List<MComment> textComments = Utils.newList();
        List<MComment> audioComments = Utils.newList();

        this.getComments(textComments, audioComments);

        Collections.sort(textComments);
        Collections.sort(audioComments);

        for(MComment comment: textComments){
            addTextComment(comment);
        }

        for(MComment comment: audioComments){
            addAudioComment(comment);
        }
    }

    private void getComments(List<MComment> textCommentList, List<MComment> audioCommentList){
        MPost thisPost = localDatabase.getModel(commentPage.getThisPost());

        List<Long> commentKeys = thisPost.getComments();

        for(long key: commentKeys){
            MComment comment = localDatabase.getModel(key);

            if(comment.getAudio().size() == 0) {
                if (!commentPage.getCurrentComments().contains(comment.getKey())) {
                    textCommentList.add(comment);
                }
            }
            else{
                if(!sec1.getCurrentComments().contains(comment.getKey())){
                    audioCommentList.add(comment);
                }
            }
        }
    }

    private void addTextComment(MComment comment){
        User user = localDatabase.getModel(comment.getCreator());
        UserProfile profile = localDatabase.getModel(user.getProfileKey());

        String text = comment.getText();

        String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());

        commentPage.addComment(profile.getUsername(), timestamp, text);
        commentPage.getCurrentComments().add(comment.getKey());
    }

    private void addAudioComment(MComment comment){
        User user = localDatabase.getModel(comment.getCreator());
        UserProfile profile = localDatabase.getModel(user.getProfileKey());


        MAudio audio = localDatabase.getModel(comment.getAudio().get(0));

        String timestamp = Constants.getCurrentTimestamp(comment.getTimeStamp());

        sec1.addPost(profile.getUsername(), timestamp, audio);
        sec1.getCurrentComments().add(comment.getKey());
    }



}
