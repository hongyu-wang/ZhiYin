package server.services.userService;

import server.model.media.Image;
import server.model.user.User;
import server.model.user.UserProfile;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class ProfileManagerImplementation implements ProfileManager {
    @Override
    public UserProfile requestProfileData(String user) {
        UserProfile profile = new UserProfile();
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
