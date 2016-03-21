package client.pages.pageInternal.modelStorage;

import server.model.media.MHashtag;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.webclient.WebServiceClient;
import server.webclient.webErrors.WebRequestException;
import server.webservices.PostObject;
import server.webservices.RequestObject;

import java.util.HashMap;
import java.util.Map;

/**A storage object of all model types the user client will need.
 *
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public class ModelStorage {
    User user;
    private Map<Long, ServerModel> models;
    private Map<String, Long> hashtag_key;
    private Map<String, Long> username_key;

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
     * @return      The model, or null if the model does not exist.
     */
    public <E extends ServerModel> E getModel(long key){
        try {
            return (E) models.get(key);
        }
        catch(ClassCastException e){
            return null;
        }
    }

    /**Pushes the model into the database.
     *
     * If it fails to send it to the server the system will return false;
     *
     * @param model The new model.
     * @return      True if it sucessfully pushed to server.
     */
    public void pushModel(ServerModel model){
        models.put(model.getKey(), model);
        PostObject.newInstance().addModel(model, model.getClass().getName());
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

    public long getHashtagByName(String hashtag){
//        try{
//            MHashtag tag = this.getModel(WebServiceClient.getHashtagByName(hashtag));
//            return tag;
//        }
//        catch(WebRequestException e){
//            System.out.println("Unable to get hashtag.");
//        }
//        return null;

        //TODO // FIXME: 2016-03-20
        return 0;
    }

    public void requestModelFromServer(String className, long key){
        RequestObject.newInstance().getModel(className, key);
    }


    /**Call this to update models within this class.
     *
     * @param model The updated model.
     */
    public void setModelFromServer(ServerModel model){
        models.put(model.getKey(), model);
    }


    /**Returns the owner of the app.
     *
     * @return  The user data of the owner.
     */
    public User getUser(){
        return user;
    }
}
