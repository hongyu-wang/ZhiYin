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
        return null;
        //TODO
    }

    @Override
    public User modifyUserName(User user, String username) {
        return null;
    }

    @Override
    public User modifyDescription(User user, String description) {
        return null;
    }

    @Override
    public User modifyDP(User user, Image image) {
        return null;
    }
}
