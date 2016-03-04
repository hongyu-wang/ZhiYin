package server.model.user;

/**A user of Zhi Yin. Contains all the necessary information for the user.
 *
 * A model filled with the information on a user.
 *
 *      - ProfileManager:
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
    private UserConversations conversations;
    private UserDiaryContent diary;
    private UserActivityLog log;
    private UserUploadedContent content;


    public User(){

    }

    public User(UserProfile prof, UserConversations convo, UserDiaryContent diary, UserActivityLog log, UserUploadedContent cont){
        init(prof, convo, diary, log, cont);
    }

    public void init(UserProfile prof, UserConversations convo, UserDiaryContent diary, UserActivityLog log, UserUploadedContent cont){
        this.profile = prof;
        this.conversations = convo;
        this.diary = diary;
        this.log = log;
        this.content = cont;
    }


}
