package server.services.userService;

import server.model.soundCloud.MMusicPost;
import server.model.user.UserUploadedContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserContentManager {
    /**Requests the server for all the content related to a user.
     *
     * @param contentKey    The user's key.
     * @return              The MMusicPost model containing all user content.
     */
    UserUploadedContent requestAllContent(long contentKey);

    /**Adds the content to the user and updates the server.
     *
     * @param content       The user content.
     * @param musicPost     The musicPost.
     * @return              The modified user.
     */
    UserUploadedContent addContentEntry(UserUploadedContent content, MMusicPost musicPost);
}
