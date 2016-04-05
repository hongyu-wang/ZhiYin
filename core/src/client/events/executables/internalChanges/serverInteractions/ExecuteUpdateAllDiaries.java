package client.events.executables.internalChanges.serverInteractions;

import client.pages.musicDiary.Diary1;
import client.tools.Constants;
import server.model.social.MDiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.util.Collections;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateAllDiaries extends ExecuteUpdate{
    private Diary1 diary1;

    public ExecuteUpdateAllDiaries(Diary1 diary1){
        this.diary1 = diary1;
    }

    @Override
    public void execute() {
        User user1 = localDatabase.getModel(1);
        User user2 = localDatabase.getModel(2);
        User user3 = localDatabase.getModel(3);

        List<MDiaryPost> posts = Utils.newList();

        updateFromServer(user1, posts);
        updateFromServer(user2, posts);
        updateFromServer(user3, posts);

        Collections.sort(posts);

        showOnScreen(posts);
    }

    private void updateFromServer(User user, List<MDiaryPost> posts){
        UserDiaryContent diaryContent = localDatabase.getModel(user.getDiary());
        for(long key: diaryContent.getDiaryKeys()){
            posts.add(localDatabase.getModel(key));
        }
    }

    private void showOnScreen(List<MDiaryPost> posts){
        for(MDiaryPost post: posts){
            if(!diary1.getCurrentDiaries().contains(post.getKey())) {
                User user = localDatabase.getModel(post.getCreator());
                UserProfile profile = localDatabase.getModel(user.getProfileKey());

                String username = profile.getUsername();

                diary1.addPost(post, username, Constants.getCurrentTimestamp(post.getTimeStamp()));

                diary1.getCurrentDiaries().add(post.getKey());
            }
        }
    }
}
