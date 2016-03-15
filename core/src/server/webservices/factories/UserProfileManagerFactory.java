package server.webservices.factories;

import server.services.interfaces.models.UserProfileManager;
import server.services.userService.UserProfileManagerImplementation;

/**
 * @author rsang
 */
public class UserProfileManagerFactory {

    private static UserProfileManager userProfileManager;

    public static UserProfileManager createUserProfileManager() {
        if (userProfileManager == null) {
            userProfileManager  = new UserProfileManagerImplementation();
        }
        return userProfileManager;
    }

    private UserProfileManagerFactory(){}

}
