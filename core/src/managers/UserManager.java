package managers;

import server.MockServer;
import yonghu.User;

/**
 * Created by Kevin Zheng on 2016-02-18.
 */
public class UserManager {
    User user;
    public UserManager(User user){
        this.user = user;
    }

    /**Logs the customer into their account, based on their User.
     *
     * @param user
     * @param pass
     * @return
     */
    public boolean login(String user, String pass){
        /**boolean validUser = MockServer.checkLogin(user, pass);
        if (validUser){
            this.user = new User(MockServer.getUserData(user));
        }*/
        return false;
    }
}
