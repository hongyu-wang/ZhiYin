package server.services.serviceInterfaces;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface UserLoginManager {
    /**Requests authentication from the server for a user and pass combo.
     *
     * @param user  The username.
     * @param pass  The password.
     * @return      True if the combination was correct.
     */
    long requestAuthenticationKey(String user, String pass);

    /**Requests the server for all relevant information on a user based on
     * a username.
     *
     * @param userKey   The user's key.
     * @return          A user class with all relevant information.
     */
    User requestUserData(long userKey);
}
