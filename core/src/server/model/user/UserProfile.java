package server.model.user;

import server.model.media.Image;

/**A model of all relevant and basic user information.
 *
 *      - username
 *      - password
 *      - "Other basic user information."
 *
 * Created by Kevin Zheng on 2016-03-02.
 *
 */
public class UserProfile {
    private String username;
    private String description;
    private Image dp;

    public UserProfile(String username, String description, Image dp){
        init(username, description, dp);
    }

    public void init(String username, String description, Image dp){
        this.username = username;
        this.description = description;
        this.dp = dp;
    }


}
