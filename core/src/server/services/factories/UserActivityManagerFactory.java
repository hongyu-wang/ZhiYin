package server.services.factories;

import server.services.implementations.userService.UserActivityManagerImplementation;
import server.services.interfaces.models.UserActivityManager;

/**
 * @author rsang
 */
public class UserActivityManagerFactory {

    private static UserActivityManager UserActivityManager;

    public static UserActivityManager createUserActivityManager() {
        if (UserActivityManager == null) {
            UserActivityManager  = new UserActivityManagerImplementation();
        }
        return UserActivityManager;
    }

    private UserActivityManagerFactory(){}

}
