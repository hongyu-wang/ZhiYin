package server.services.implementations.userService;

import server.model.user.*;
import server.services.interfaces.models.UserManager;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserManagerImplementation implements UserManager {
    public UserManagerImplementation(){

    }

    /**Requests Authentication.
     *
     * @param user  The username.
     * @param pass  The password.
     * @return      The key of the user model.
     */
//
//    /**Retrieves all relevant information on the user.
//     *
//     * @param userKey   The userkey of the user.
//     * @return          The user class with all information.
//     */
//    @Override
//    public User requestUserData(long userKey) {
//
//        User user = new User();
//        user.setKey(userKey);
//
//        long userContent = 0;
//        long conversations = 0;
//        long diary = 0;
//        long log = 0;
//        long profile = 0;
//        List<Long> friends = null;
//
//        user.setContent(userContent);
//        user.setConversations(conversations);
//        user.setDiary(diary);
//        user.setLog(log);
//        user.setProfile(profile);
//        user.setFriends(friends);
//        return user;
//    }

    @Override
    public User createNewUser(String user, String pass){
        User newUser = new User();
        return newUser;
    }

}
