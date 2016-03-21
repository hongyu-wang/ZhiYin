package server.services.factories;

import server.services.implementations.userService.UserContentManagerImplementation;
import server.services.interfaces.models.UserContentManager;

/**
 * @author rsang
 */
public class UserContentManagerFactory {

    private static UserContentManager UserContentManager;

    public static UserContentManager createUserContentManager() {
        if (UserContentManager == null) {
            UserContentManager  = new UserContentManagerImplementation();
        }
        return UserContentManager;
    }

    private UserContentManagerFactory(){}

}
