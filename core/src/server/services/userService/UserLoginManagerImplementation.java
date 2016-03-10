package server.services.userService;

import server.model.user.*;

import java.util.List;

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
     * @return      The key of the user model.
     */
    @Override
    public long requestAuthenticationKey(String user, String pass) {
        long userKey = 0;
        return userKey;
        //TODO request from server.
    }

    /**Retrieves all relevant information on the user.
     *
     * @param userKey   The userkey of the user.
     * @return          The user class with all information.
     */
    @Override
    public User requestUserData(long userKey) {

        User user = new User();
        user.setKey(userKey);

        long userContent = 0;
        //TODO request from server.
        long conversations = 0;
        //TODO request from server.
        long diary = 0;
        //TODO request from server.
        long log = 0;
        //TODO request from server.
        long profile = 0;
        //TODO request from server.
        List<Long> friends = null;

        user.setContent(userContent);
        user.setConversations(conversations);
        user.setDiary(diary);
        user.setLog(log);
        user.setProfile(profile);
        user.setFriends(friends);
        return user;
    }
}
