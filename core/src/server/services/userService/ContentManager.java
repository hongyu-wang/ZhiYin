package server.services.userService;

import server.model.musicSharing.UserContent;
import server.model.social.Post;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface ContentManager {
    /**Requests the server for all the content related to a user.
     *
     * @param user  The username.
     * @return  The UserContent model containing all user content.
     */
    UserContent requestAllContent(String user);
}
