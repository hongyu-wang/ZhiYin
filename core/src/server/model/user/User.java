package server.model.user;

/**A model filled with the information on a user.
 *
 *      - Profile:
 *          -Basic user information.
 *      - Conversations
 *      - Diary Content
 *      - Uploaded Content
 *      - Activity Log
 *
 * Created by Kevin Zheng on 2016-02-18.
 */
public class User {
    private UserProfile profile;
    private UserConversations conversation;
    private UserDiaryContent diary;
    private UserActivityLog log;
    private UserUploadedContent content;

    /**A user of Zhi Yin. Contains all the necessary information for the user.
     *
     */
    public User(){

    }
}
