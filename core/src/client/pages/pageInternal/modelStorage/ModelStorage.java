package client.pages.pageInternal.modelStorage;

import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hongyu Wang on 3/19/2016.
 */
public class ModelStorage {
    User user;
    Map<Long, ServerModel> models;

    public ModelStorage(){
        models = new HashMap<Long, ServerModel>();
    }

    public ModelStorage(User user){
        this.user = user;
        models = new HashMap<Long, ServerModel>();
        models.put(user.getKey(), user);
    }

    /**Returns the model based on a key.
     *
     * If the model has already been stored on the phone then return that.
     *
     * Otherwise request the model from the server.
     *
     * @param key
     * @param <E>
     * @return
     */
    public <E> E getModel(long key){
        if(models.containsKey(key)){
            return (E)models.get(key);
        }
        try{
            return WebServiceClient.<E>getServerModel(key);
        }
        catch(WebRequestException e){
            System.out.println("ServerRequest failed.");
        }
        return null;
    }

}
