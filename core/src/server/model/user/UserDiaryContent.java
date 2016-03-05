package server.model.user;

import server.model.musicDiary.DiaryPost;

import java.util.List;

/**A model filled with every user Diary Post.
 *
 *      - DiaryPost
 *      - Comment
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserDiaryContent {
    List<String> diaryKeys;
    List<DiaryPost> diaryposts;

    /**Returns all keys to user diaryPosts.
     *
     * @return  The service list of all userDiaryPosts.
     */
    public List<String> getDiaryKeys() {
        return diaryKeys;
    }

    /**Returns all user diaryPosts.
     *
     * @return  The List of all diaryPosts.
     */
    public List<DiaryPost> getDiaryposts() {
        return diaryposts;
    }

    public void setDiaryposts(List<DiaryPost> diaryposts) {
        this.diaryposts = diaryposts;
    }
    public void setDiaryKeys(List<String> diaryKeys) {
        this.diaryKeys = diaryKeys;
    }

}
