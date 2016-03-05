package server.services.userService;

import server.model.social.MusicPost;
import server.model.user.User;
import server.model.user.UserUploadedContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ContentManager {
    /**Requests the server for all the content related to a user.
     *
     * @param user  The username.
     * @return  The MusicPost model containing all user content.
     */
    UserUploadedContent requestAllContent(String user);

    /**Adds the content to the user and updates the server.
     *
     * @param user      The user.
     * @param musicPost The musicPost.
     * @return          The modified user.
     */
    User addContentEntry(User user, MusicPost musicPost);
}
