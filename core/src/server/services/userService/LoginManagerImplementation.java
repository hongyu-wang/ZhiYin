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
        //TODO
    }

    /**Retrieves all relevant information on the user.
     *
     * @param user  The username of the user.
     * @return  The user class with all information.
     */
    @Override
    public User requestUserData(String user) {
        return null;
        //TODO Implement.
    }
}
