package server.services.interfaces.models;

import server.model.social.MDiaryPost;
import server.model.user.UserDiaryContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public interface UserDiaryManager {

    /**Adds new diary post to the user and to the server.
     *
     * @param diary      The user's diaryposts.
     * @param diaryPost  The new diarypost.
     * @return           The modified user.
     */
    UserDiaryContent addDiaryPost(UserDiaryContent diary, MDiaryPost diaryPost);
}
