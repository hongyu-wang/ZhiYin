package server.services.userService;

import server.model.media.MImage;
import server.model.user.UserProfile;
import server.services.interfaces.models.UserProfileManager;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserProfileManagerImplementation implements UserProfileManager {
//    @Override
//    public UserProfile requestProfileData(long userKey) {
//        UserProfile profile = new UserProfile();
//        return profile;
//        //TODO request from server.
//    }

    @Override
    public UserProfile modifyUserName(UserProfile profile, String username) {
        profile.setUsername(username);
        return profile;
        //TODO request change to server.
    }

    @Override
    public UserProfile modifyDescription(UserProfile profile, String description) {
        profile.setDescription(description);
        return profile;
        //TODO request change to server.
    }

    @Override
    public UserProfile modifyDP(UserProfile profile, MImage image) {
        profile.setImageKey(image.getKey());
        return profile;
        //TODO request change to server.
    }
}
