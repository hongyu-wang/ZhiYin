package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A user of Zhi Yin. Contains all the necessary information for the user.
 *
 * A model filled with the information on a user.
 *
 *      - UserProfileManager:
 *          -Basic user information.
 *      - Conversations
 *      - Diary Content
 *      - Uploaded Content
 *      - Activity Log
 *
 * Created by Kevin Zheng on 2016-02-18.
 */
public class User extends ServerModel {
    private long profileKey;
    private long conversationsKey;
    private long diaryKey;
    private long logKey;
    private long contentKey;

    //TODO Implement friends.

    /**Gets all basic user information.
     *
     * @return  The userProfile containing info.
     */
    public long getProfile() {
        return profileKey;
    }

    /**Returns a model of all conversations a user has.
     *
     * @return  The userConversation containing convos.
     */
    public long getConversations() {
        return conversationsKey;
    }

    /**Returns a model of all diary posts a user has.
     *
     * @return  The userDiaryContent.
     */
    public long getDiary() {
        return diaryKey;
    }

    /**Returns a model of all uploaded content a user has.
     *
     * @return  The userUploadedContent.
     */
    public long getContent() {
        return contentKey;
    }

    /**Gets all logged activity of the user.
     *
     * @return  The userActivitylog.
     */
    public long getLog() {
        return logKey;
    }

//    /**Gets the list of all friend keys.
//     *
//     * @return  The List of friend keys.
//     */
//    public List<Long> getFriendKeys() {
//        return friendKeys;
//    }
//
//    /**Gets the list of user friends.
//     *
//     * @return  The List of users which are friends with the user.
//     */
//    public List<String> getFriends() {
//        return friends;
//    }

    // SETTERS
    public void setProfile(long profileKey) {
        this.profileKey = profileKey;
    }
    public void setConversations(long conversationsKey) {
        this.conversationsKey = conversationsKey;
    }
    public void setDiary(long diaryKey) {
        this.diaryKey = diaryKey;
    }
    public void setLog(long logKey) {
        this.logKey = logKey;
    }
    public void setContent(long contentKey) {
        this.contentKey = contentKey;
    }
//    public void setFriendKeys(List<Long> friendKeys) {
//        this.friendKeys = friendKeys;
//    }
//    public void setFriends(List<String> friends) {
//        this.friends = friends;
//    }
}
