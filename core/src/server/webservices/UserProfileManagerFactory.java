package server.webservices;

import server.services.serviceInterfaces.UserProfileManager;
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
}
