package server.services.interfaces.models;

import server.model.media.MImage;
import server.model.user.UserProfile;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserProfileManager {

    /**Modify the username.
     *
     * @param profile       The user's profile.
     * @param username      The new username.
     * @return              The modified user profile model.
     */
    UserProfile modifyUserName(UserProfile profile, String username);

    /**Modify the description.
     *
     * @param profile          The user's profile.
     * @param description      The new description.
     * @return                 The modified user profile model.
     */
    UserProfile modifyDescription(UserProfile profile, String description);

    /**Modify the profile picture.
     *
     * @param profile   The user's profile.
     * @param image     The new image of profile picutre/
     * @return          The modified user profile model
     */
    UserProfile modifyDP(UserProfile profile, MImage image);
}
