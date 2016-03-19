package server.services.interfaces.models;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface UserManager {

    /**Creates a new user to the database, based on a username and password.
     *
     * @param user  The usename.
     * @param pass  The password.
     * @return      The newly generated user.
     */
    User createNewUser(String user, String pass);

}
