package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A model filled with every user Diary MPost.
 *
 *      - MDiaryPost
 *      - MComment
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserDiaryContent extends ServerModel {
    /**
     * The list of keys to the diary posts.
     */
    List<Long> diaryKeys;

    /**Returns all keys to user diaryPosts.
     *
     * @return  The service list of all userDiaryPosts.
     */
    public List<Long> getDiaryKeys() {
        return diaryKeys;
    }

    public void setDiaryKeys(List<Long> diaryKeys) {
        this.diaryKeys = diaryKeys;
    }

}
