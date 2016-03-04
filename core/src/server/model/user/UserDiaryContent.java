package server.model.user;

import server.model.musicDiary.DiaryPost;
import tools.ServiceList;

/**A model filled with every user Diary Post.
 *
 *      - DiaryPost
 *      - Comment
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserDiaryContent {
    ServiceList<String>    diaryKeys;
    ServiceList<DiaryPost> diaryposts;

    /**Returns all keys to user diaryPosts.
     *
     * @return  The service list of all userDiaryPosts.
     */
    public ServiceList<String> getDiaryKeys() {
        return diaryKeys;
    }

    /**Returns all user diaryPosts.
     *
     * @return  The serviceList of all diaryPosts.
     */
    public ServiceList<DiaryPost> getDiaryposts() {
        return diaryposts;
    }

    public void setDiaryposts(ServiceList<DiaryPost> diaryposts) {
        this.diaryposts = diaryposts;
    }
    public void setDiaryKeys(ServiceList<String> diaryKeys) {
        this.diaryKeys = diaryKeys;
    }

}
