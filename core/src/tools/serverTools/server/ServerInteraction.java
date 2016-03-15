package tools.serverTools.server;

import tools.serverTools.server.MockServer;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class ServerInteraction {
    private static MockServer server;
    public static MockServer getServer(){
        if(server == null){
            server = new MockServer();
        }
        return server;
    }

}
