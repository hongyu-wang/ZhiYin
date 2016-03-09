package server.services.userService;

import server.model.media.MImage;
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
     * @param profile       The user.
     * @param username      The new username.
     * @return              The modified user profile model.
     */
    UserProfile modifyUserName(UserProfile profile, String username);

    /**Modify the description.
     *
     * @param profile          The user.
     * @param description      The new description.
     * @return                 The modified user profile model.
     */
    UserProfile modifyDescription(UserProfile profile, String description);

    /**Modify the profile picture.
     *
     * @param profile   The user.
     * @param image     The new image of profile picutre/
     * @return          The modified user profile model
     */
    UserProfile modifyDP(UserProfile profile, MImage image);
}