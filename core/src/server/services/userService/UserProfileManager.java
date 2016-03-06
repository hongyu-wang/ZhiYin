package server.services.userService;

import server.model.media.Image;
import server.model.user.User;
import server.model.user.UserProfile;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserProfileManager {
    /**Requests the user's profile data from the server based on a username.
     *
     * @param userKey   The user's key.
     * @return          The UserProfile model for user profile.
     */
    UserProfile requestProfileData(long userKey);

    /**Modify the username.
     *
     * @param user      The user.
     * @param username  The new username.
     * @return          The modified user model.
     */
    User modifyUserName(User user, String username);

    /**Modify the description.
     *
     * @param user          The user.
     * @param description   The new description.
     * @return              The modified user model.
     */
    User modifyDescription(User user, String description);

    /**Modify the profile picture.
     *
     * @param user  The user.
     * @param image The new image of profile picutre/
     * @return
     */
    User modifyDP(User user, Image image);
}
