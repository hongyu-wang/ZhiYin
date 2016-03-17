package server.services.factories;

import server.services.implementations.userService.UserDiaryManagerImplementation;
import server.services.interfaces.models.UserDiaryManager;

/**
 * @author rsang
 */
public class UserDiaryManagerFactory {

    private static UserDiaryManager UserDiaryManager;

    public static UserDiaryManager createUserDiaryManager() {
        if (UserDiaryManager == null) {
            UserDiaryManager  = new UserDiaryManagerImplementation();
        }
        return UserDiaryManager;
    }

    private UserDiaryManagerFactory(){}

}
