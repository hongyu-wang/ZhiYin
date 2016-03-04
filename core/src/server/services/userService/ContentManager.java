package server.services.userService;

import server.model.musicSharing.MusicPost;
import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ContentManager {
    /**Requests the server for all the content related to a user.
     *
     * @param user  The username.
     * @return  The MusicPost model containing all user content.
     */
    MusicPost requestAllContent(String user);

    /**Adds the content to the user and updates the server.
     *
     * @param user      The user.
     * @param musicPost The musicPost.
     * @return          The modified user.
     */
    User addContentEntry(User user, MusicPost musicPost);
}
