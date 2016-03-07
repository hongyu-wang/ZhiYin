package server.model.user;

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

    private long imageKey;

    /**Returns the username of the user.
     *
     * @return  The username string.
     */
    public String getUsername() {
        return username;
    }

    /**Returns the description of the user.
     *
     * @return The string description.
     */
    public String getDescription() {
        return description;
    }

    /**Returns the key of the profile picture.
     *
     * @return  The long of the key.
     */
    public long getImageKey() {
        return imageKey;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImageKey(long imageKey) {
        this.imageKey = imageKey;
    }
}
