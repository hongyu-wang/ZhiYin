package server.services.userService;

import server.model.user.UserDiaryContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface DiaryManager {
    /**Requests the server for all diary contents based on a username.
     *
     * @param user  The username.
     * @return  The UserDiaryContents filled with user diary entries.
     */
    UserDiaryContent requestAllDiaryContent(String user);
}
