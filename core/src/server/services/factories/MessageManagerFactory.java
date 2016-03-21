package server.services.factories;

import server.services.implementations.socialService.MessageManagerImplementation;
import server.services.interfaces.models.MessageManager;

/**
 * @author rsang
 */
public class MessageManagerFactory {

    private static MessageManager MessageManager;

    public static MessageManager createMessageManager() {
        if (MessageManager == null) {
            MessageManager  = new MessageManagerImplementation();
        }
        return MessageManager;
    }

    private MessageManagerFactory(){}

}
