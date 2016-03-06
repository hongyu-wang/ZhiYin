package server.model.user;

import server.model.media.Image;
import server.model.structureModels.ServerModel;

/**A model of all relevant and basic user information.
 *
 *      - username
 *      - password
 *      - "Other basic user information."
 *
 * Created by Kevin Zheng on 2016-03-02.
 *
 */
public class UserProfile extends ServerModel {
    private String username;
    private String description;
    private Image dp;

    /**Returns the username of the user.
     *
     * @return  The username string.
     */
    public String getUsername() {
        return username;
    }

    /**Returns the description of the user.
     *
     * @param description   The string description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**Returns the profile picture of the user.
     *
     * @return  The Image profile pic.
     */
    public Image getProfilePic() {
        return dp;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setProfilePic(Image dp) {
        this.dp = dp;
    }
}
