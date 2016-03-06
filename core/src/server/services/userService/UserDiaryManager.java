package server.services.userService;

import server.model.social.DiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserDiaryManager {
    /**Requests the server for all diary contents based on a username.
     *
     * @param userKey   The user's key.
     * @return          The UserDiaryContents filled with user diary entries.
     */
    UserDiaryContent requestAllDiaryContent(long userKey);

    /**Adds new diary post to the user and to the server.
     *
     * @param user      The user.
     * @param diaryPost The new diarypost.
     * @return          The modified user.
     */
    User addDiaryPost(User user, DiaryPost diaryPost);
}
