package server.services.factories;

import server.services.implementations.userService.UserManagerImplementation;
import server.services.interfaces.models.UserManager;

/**
 * @author rsang
 */
public class UserManagerFactory {

    private static UserManager UserManager;

    public static UserManager createUserManager() {
        if (UserManager == null) {
            UserManager  = new UserManagerImplementation();
        }
        return UserManager;
    }

    private UserManagerFactory(){}

}
