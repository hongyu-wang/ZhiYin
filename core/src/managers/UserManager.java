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

    public static UserManager login(String user, String pass){
        MockServer.checkLogin(user, pass);
    }
}
