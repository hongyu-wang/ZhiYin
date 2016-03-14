package tools.serverTools.server;

import tools.serverTools.server.MockServer;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class ServerInteraction {
    private static MockServer server = new MockServer();
    public static MockServer getServer(){
        return server;
    }

}
