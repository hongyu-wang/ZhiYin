package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.FriendProfile;
import client.stateInterfaces.Profile;
import server.model.social.MDiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateProfileDiary extends ExecuteUpdate {
    private Profile friendProfile;
    private String name;

    public ExecuteUpdateProfileDiary(Profile friendProfile, String name) {
        this.friendProfile = friendProfile;
        this.name = name;
    }

    @Override
    public void execute() {
        User user = localDatabase.getModel(localDatabase.getUserKeyByName(name));
        updateDiariesFromServer(user);
    }

    private void updateDiariesFromServer(User user){
        UserDiaryContent diaryContent = localDatabase.getModel(user.getDiary());

        boolean isUpdated = true;

        for(long key: diaryContent.getDiaryKeys()){
            if(!friendProfile.getCurrentDiaries().contains(key)) {
                if(localDatabase.getModel(key) == null){
                    localDatabase.requestModelFromServer(key);
                    isUpdated = false;
                }
                MDiaryPost post = localDatabase.getModel(key);
                if(localDatabase.getModel(post.getText())== null){
                    localDatabase.requestModelFromServer(post.getText());
                    isUpdated = false;
                }

                if(!isUpdated)
                    continue;

                friendProfile.addPost(post);

                friendProfile.getCurrentDiaries().add(key);
            }
        }
    }
}
