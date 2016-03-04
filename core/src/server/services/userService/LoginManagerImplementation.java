package server.services.userService;

import server.model.user.*;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class LoginManagerImplementation implements LoginManager {
    public LoginManagerImplementation(){

    }

    /**Requests Authentication.
     *
     * @param user  The username.
     * @param pass  The password.
     * @return  True if the user/pass combo is correct.
     */
    @Override
    public boolean validateLogin(String user, String pass) {
        return false;
        //TODO request from server.
    }

    /**Retrieves all relevant information on the user.
     *
     * @param username  The username of the user.
     * @return  The user class with all information.
     */
    @Override
    public User requestUserData(String username) {

        User user = new User();

        UserUploadedContent userContent = new ContentManagerImplementation().requestAllContent(username);
        UserConversations conversations = new ConversationManagerImplementation().requestAllConversations(username);
        UserDiaryContent diary = new DiaryManagerImplementation().requestAllDiaryContent(username);
        UserActivityLog log = new ActivityManagerImplementation().requestLog(username);
        UserProfile profile = new ProfileManagerImplementation().requestProfileData(username);

        user.setContent(userContent);
        user.setConversations(conversations);
        user.setDiary(diary);
        user.setLog(log);
        user.setProfile(profile);
        return user;
    }
}
