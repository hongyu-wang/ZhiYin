package server.webservices.factories;

import server.services.interfaces.ServerModelManager;
import server.services.serverService.ServerModelManagerImplementation;

/**
 * Created by Kevin Zheng on 2016-03-14.
 */
public class ServerModelManagerFactory {
    private static ServerModelManager ourInstance = new ServerModelManagerImplementation();

    public static ServerModelManager getInstance() {
        return ourInstance;
    }

    private ServerModelManagerFactory() {}
}
