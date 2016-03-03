package server.services.userService;

import server.model.user.UserProfile;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ProfileManager {
    /**Requests the user's profile data from the server based on a username.
     *
     * @param user  The username.
     * @return      The UserProfile model for user profile.
     */
    UserProfile requestProfileData(String user);
}
