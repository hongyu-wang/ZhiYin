package server.services.loginService;

import server.model.user.User;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class Login implements LoginInterface{
    public Login(){

    }

    /**
     *
     * @param user  The username.
     * @param pass  The password.
     * @return
     */
    @Override
    public boolean validateLogin(String user, String pass) {
        return false;
    }

    @Override
    public User retrieveUserData(String user) {
        return null;
    }
}
