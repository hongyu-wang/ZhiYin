package server.services.factories;

import server.services.implementations.userService.UserConversationManagerImplementation;
import server.services.interfaces.models.UserConversationManager;

/**
 * @author rsang
 */
public class UserConversationManagerFactory {

    private static UserConversationManager UserConversationManager;

    public static UserConversationManager createUserConversationManager() {
        if (UserConversationManager == null) {
            UserConversationManager  = new UserConversationManagerImplementation();
        }
        return UserConversationManager;
    }

    private UserConversationManagerFactory(){}

}
