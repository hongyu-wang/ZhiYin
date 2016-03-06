package server.services.userService;

import server.model.media.Image;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.mediaService.ImageManagerImplementation;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserProfileManagerImplementation implements UserProfileManager {
    @Override
    public UserProfile requestProfileData(long userKey) {
        UserProfile profile = new UserProfile();

        String description = null;  //Server request
        profile.setDescription(description);

        String username = null;     //Server request
        profile.setUsername(username);

        long key = 0;               //Server request
        profile.setKey(key);

        Image dp = new ImageManagerImplementation().requestImage(profile.getImageKey());
        profile.setProfilePic(dp);

        return profile;
        //TODO request from server.
    }

    @Override
    public User modifyUserName(User user, String username) {
        user.getProfile().setUsername(username);
        return user;
        //TODO request change to server.
    }

    @Override
    public User modifyDescription(User user, String description) {
        user.getProfile().setDescription(description);
        return user;
        //TODO request change to server.
    }

    @Override
    public User modifyDP(User user, Image image) {
        user.getProfile().setProfilePic(image);
        return user;
        //TODO request change to server.
    }
}
