package client.pages.pageInternal.modelStorage;

import server.model.media.MHashtag;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;

import java.util.HashMap;
import java.util.Map;

/**A storage object of all model types the user client will need.
 *
 *
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
    public <E extends ServerModel> E getModel(long key){
        if(models.containsKey(key)){
            return (E)models.get(key);
        }
        return updateModel(key);
    }

    /**Updates the model based on a key.
     *
     * For messages, conversations, and posts which require constant updating
     * this method is used to pull a more current state from the server.
     *
     * @param key   The key.
     * @param <E>   The type of the model.
     * @return      The serverModel.
     */
    public <E extends ServerModel> E updateModel(long key){
        try{
            E model = WebServiceClient.<E>getServerModel(key);
            models.put(model.getKey(), model);
            return model;
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

    /**Sets the prime user of this app.
     *
     * @param username  The username.
     * @return          True if the login was successful.
     */
    public boolean loginUser(String username){
        try {
            this.user = this.getModel(WebServiceClient.getUserByName(username));
            return true;
        }
        catch(WebRequestException e){
            System.out.println("Unable to login.");
            return false;
        }
    }

    public MHashtag getHashtagByName(String hashtag){
        try{
            MHashtag tag = this.getModel(WebServiceClient.getHashtagByName(hashtag));
            return tag;
        }
        catch(WebRequestException e){
            System.out.println("Unable to get hashtag.");
        }
        return null;
    }

    /**Returns the owner of the app.
     *
     * @return  The user data of the owner.
     */
    public User getUser(){
        return user;
    }
}
