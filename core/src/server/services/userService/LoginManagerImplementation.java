package server.services.userService;

import server.model.user.User;

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
     * @param user  The username of the user.
     * @return  The user class with all information.
     */
    @Override
    public User requestUserData(String user) {
        User user = new User();
        user.setContent();
        user.setConversations();
        user.setDiary();
        user.getLog();
        user.setProfile();
        return user;
        //TODO implement proper calls to other managers.
        //TODO request from server.
    }
}
