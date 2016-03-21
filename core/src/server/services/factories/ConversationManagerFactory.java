package server.services.factories;

import server.services.implementations.socialService.ConversationManagerImplementation;
import server.services.interfaces.models.ConversationManager;

/**
 * @author rsang
 */
public class ConversationManagerFactory {

    private static ConversationManager ConversationManager;

    public static ConversationManager createConversationManager() {
        if (ConversationManager == null) {
            ConversationManager  = new ConversationManagerImplementation();
        }
        return ConversationManager;
    }

    private ConversationManagerFactory(){}

}
