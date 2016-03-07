package server.services.userService;

import server.model.social.MusicPost;
import server.model.user.User;
import server.model.user.UserUploadedContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserContentManager {
    /**Requests the server for all the content related to a user.
     *
     * @param contentKey    The user's key.
     * @return              The MusicPost model containing all user content.
     */
    UserUploadedContent requestAllContent(long contentKey);

    /**Adds the content to the user and updates the server.
     *
     * @param content       The user content.
     * @param musicPost     The musicPost.
     * @return              The modified user.
     */
    UserUploadedContent addContentEntry(UserUploadedContent content, MusicPost musicPost);
}
