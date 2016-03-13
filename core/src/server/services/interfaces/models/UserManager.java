package server.services.interfaces.models;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface UserManager {
    /**Requests authentication from the server for a user and pass combo.
     *
     * @param user  The username.
     * @param pass  The password.
     * @return      True if the combination was correct.
     */
    long requestAuthenticationKey(String user, String pass);

    /**Creates a new user to the database, based on a username and password.
     *
     * @param user  The usename.
     * @param pass  The password.
     * @return      The newly generated user.
     */
    User createNewUser(String user, String pass);

}
