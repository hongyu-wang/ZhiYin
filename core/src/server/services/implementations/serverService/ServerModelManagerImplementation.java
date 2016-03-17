package server.services.implementations.serverService;

import server.model.structureModels.ServerModel;
import server.services.interfaces.ServerModelManager;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;
import tools.serverTools.server.ServerInteraction;

/**
 * Created by Kevin Zheng on 2016-03-11.
 */
public class ServerModelManagerImplementation implements ServerModelManager {
    @Override
    public <E> E requestModel(long key) throws Exception{
        try{
            return WebServiceClient.getServerModel(key);
        }
        catch(ClassCastException e){
            throw new WebRequestException();
        }
    }

    @Override
    public void pushModel(ServerModel model) {
        ServerInteraction.getServer().setModel(model);
    }
}
