package server.services.userService;

import server.model.user.*;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserLoginManagerImplementation implements UserLoginManager {
    public UserLoginManagerImplementation(){

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
    public User requestUserData(String username, String pass) {

        User user = new User();

        long key = 0;   //Server request.
        user.setKey(key);
        //TODO request from server.

        UserUploadedContent userContent = new UserContentManagerImplementation().requestAllContent(key);
        UserConversations conversations = new UserConversationManagerImplementation().requestAllConversations(key);
        UserDiaryContent diary = new UserDiaryManagerImplementation().requestAllDiaryContent(key);
        UserActivityLog log = new UserActivityManagerImplementation().requestLog(key);
        UserProfile profile = new UserProfileManagerImplementation().requestProfileData(key);

        user.setContent(userContent);
        user.setConversations(conversations);
        user.setDiary(diary);
        user.setLog(log);
        user.setProfile(profile);
        return user;
    }
}
