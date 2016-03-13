package server.services.interfaces.models;

import server.model.soundCloud.MMusicPost;
import server.model.user.UserUploadedContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserContentManager {

    /**Adds the content to the user and updates the server.
     *
     * @param content       The user content.
     * @param musicPost     The musicPost.
     * @return              The modified user.
     */
    UserUploadedContent addContentEntry(UserUploadedContent content, MMusicPost musicPost);
}
