package server.services.userService;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface LoginManager {
    /**Requests authentication from the server for a user and pass combo.
     *
     * @param user  The username.
     * @param pass  The password.
     * @return      True if the combination was correct.
     */
    boolean validateLogin(String user, String pass);

    /**Requests the server for all relevant information on a user based on
     * a username.
     *
     * @param user  The username of the user.
     * @return      A user class with all relevant information.
     */
    User retrieveUserData(String user);
}
