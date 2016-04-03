package client.events.executables.internalChanges.serverInteractions;

import client.pages.musicDiary.Diary1;
import server.model.social.MDiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.model.user.UserProfile;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

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

        updateFromServer(user1);
        updateFromServer(user2);
        updateFromServer(user3);
    }

    private void updateFromServer(User user){
        UserDiaryContent diaryContent = localDatabase.getModel(user.getDiary());

        for(long key: diaryContent.getDiaryKeys()){
            if(!diary1.getCurrentDiaries().contains(key)) {
                MDiaryPost post = localDatabase.getModel(key);
                UserProfile profile = localDatabase.getModel(user.getProfile());

                String username = profile.getUsername();

                diary1.addPost(post, username);

                diary1.getCurrentDiaries().add(key);
            }
        }
    }
}
