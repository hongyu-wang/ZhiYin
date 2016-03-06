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
    private UserProfile profile;
    private UserConversations conversations;
    private UserDiaryContent diary;
    private UserActivityLog log;
    private UserUploadedContent content;

    //TODO Implement friends.

    /**Gets all basic user information.
     *
     * @return  The userProfile containing info.
     */
    public UserProfile getProfile() {
        return profile;
    }

    /**Returns a model of all conversations a user has.
     *
     * @return  The userConversation containing convos.
     */
    public UserConversations getConversations() {
        return conversations;
    }

    /**Returns a model of all diary posts a user has.
     *
     * @return  The userDiaryContent.
     */
    public UserDiaryContent getDiary() {
        return diary;
    }

    /**Returns a model of all uploaded content a user has.
     *
     * @return  The userUploadedContent.
     */
    public UserUploadedContent getContent() {
        return content;
    }

    /**Gets all logged activity of the user.
     *
     * @return  The userActivitylog.
     */
    public UserActivityLog getLog() {
        return log;
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
    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }
    public void setConversations(UserConversations conversations) {
        this.conversations = conversations;
    }
    public void setDiary(UserDiaryContent diary) {
        this.diary = diary;
    }
    public void setLog(UserActivityLog log) {
        this.log = log;
    }
    public void setContent(UserUploadedContent content) {
        this.content = content;
    }
//    public void setFriendKeys(List<Long> friendKeys) {
//        this.friendKeys = friendKeys;
//    }
//    public void setFriends(List<String> friends) {
//        this.friends = friends;
//    }
}
