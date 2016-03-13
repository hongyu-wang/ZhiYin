package server.services.serverService;

import server.model.structureModels.ServerModel;
import server.services.interfaces.ServerModelManager;
import tools.serverTools.server.ServerInteraction;

/**
 * Created by Kevin Zheng on 2016-03-11.
 */
public class ServerModelManagerImplementation implements ServerModelManager {
    @Override
    public <E> E requestModel(long key) throws Exception{
        try{
            return (E) ServerInteraction.getServer().getModel(key);
        }
        catch(ClassCastException e){
            throw new Exception();
        }
    }

    @Override
    public void pushModel(ServerModel model) {
        ServerInteraction.getServer().setModel(model);
    }
}
