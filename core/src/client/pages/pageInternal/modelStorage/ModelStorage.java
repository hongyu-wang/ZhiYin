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

    ModelStorage(){
        models = new HashMap<Long, ServerModel>();
    }

    ModelStorage(User user){
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
     * @param key   The key of the servermodel.
     * @param <E>   The type of the model.
     * @return      The model.
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

    /**Pushes the model into the database.
     *
     * If it fails to send it to the server the system will return false;
     *
     * @param model The new model.
     * @return      True if it sucessfully pushed to server.
     */
    public boolean pushModel(ServerModel model){
        try{
            WebServiceClient.pushServerModel(model);
            models.put(model.getKey(), model);
            return true;
        }
        catch(WebRequestException e){
            System.out.println("ServerRequest failed.");
            return false;
        }
    }

    public boolean loginUser(String username){
        try {
            this.user = WebServiceClient.getUserbyName(username);
            return true;
        }
        catch(WebRequestException e){
            System.out.println("Unable to login.");
            return false;
        }
    }

    /**Returns the owner of the app.
     *
     * @return  The user data of the owner.
     */
    public User getUser(){
        return user;
    }

}
