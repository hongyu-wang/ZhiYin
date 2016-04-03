package tools.serverTools.databases;

import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import driver.GameLoop;
import server.model.serverKey.MServerKey;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.webservices.PostObject;
import server.webservices.RequestObject;
import server.webservices.ServerKeyObject;
import server.webservices.UpdateObject;
import tools.serverTools.generators.SerialGenerator;
import tools.utilities.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**A storage object of all model types the user client will need.
 *
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public class LocalDatabase {
    private long user;
    private int pullCount;
    private List<Long> pulledKeys;
    private Map<Long, ServerModel> models;
    private Map<String, Long> hashtag_key;
    private Map<String, Long> username_key;
    private SerialGenerator generator;

    public static String ipAddress = "localhost";

    /**Returns a pre generated serial key from the server.
     *
     * @return
     */
    public long generateKey(){
        long key = user*3000000;
        MServerKey keyState = this.getKeyState();
        if(generator == null){
            generator = SerialGenerator.getHGenerator(keyState.getCurrentKey());
        }

        keyState.setCurrentKey(keyState.getCurrentKey() + 1);
        return key + generator.generateSerial();
    }

    public MServerKey getKeyState(){
        return (MServerKey) models.get(this.getMainUser().getKeyState());
    }

    LocalDatabase(){
        pullCount = 0;
        models = Utils.newMap();
        hashtag_key = Utils.newMap();
        username_key = Utils.newMap();
        pulledKeys = Utils.newList();
//        unassignedKeys = new ArrayList<Long>();
    }

    public void initServerTalker(){
        TalkerFactory.getServerTalker().init(pulledKeys);
    }


    /**Sets the prime user of this app.
     *
     * @param username  The username.
     * @return          True if the login was successful.
     */
    public boolean loginUser(String username){
        user = getUserKeyByName(username);
        return true;
    }

    /**Returns the owner of the app.
     *
     * @return  The user data of the owner.
     */
    public User getMainUser(){
        return (User)models.get(user);
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
     * @param modelList The new model.
     * @return          True if it sucessfully pushed to server.
     */
    public void pushModel(List<ServerModel> modelList){
        for(ServerModel model: modelList){
            models.put(model.getKey(), model);
        }
        if(!GameLoop.ISPUSHING){
            return;
        }
        modelList.add(this.getKeyState());
        PostObject.newInstance().addModel(modelList.toArray(new ServerModel[modelList.size()]));
    }


















    /*Server Thread methods*/
    //------------------------------------------------------------------------//
    /**Requests a new model of className from the server.
     *
     * @param key
     */
    public void requestModelFromServer(long key){
        RequestObject.newInstance().getModel(key);
        if(!pulledKeys.contains(key))
            pulledKeys.add(key);
    }

    /**Updates the server based on the list of updated keys sent from the server.
     *
     * @param serverKeys
     */
    public void updateFromServerbyList(Long[] serverKeys){
        for(int i = pullCount; i < serverKeys.length; i ++){
            if(pulledKeys.contains(serverKeys[i])){
                continue;
            }
            else{
                requestModelFromServer(serverKeys[i]);
            }
        }
        pullCount = serverKeys.length;
    }

    /**Call this to update models within this class.
     *
     * @param model The updated model.
     */
    public void setModelFromServer(ServerModel model){
        models.put(model.getKey(), model);

        if(pulledKeys.contains(model.getKey())){
            pulledKeys.remove(model.getKey());
        }
    }

    /**Place the newly request server key in here.
     *
     * @param key
     */
    public void putGeneratedKey(long key){
        //unassignedKeys.add(key);
    }















    /*Get models by name.*/
    //------------------------------------------------------------------------//

    /**Returns the user's key based on a username.
     *
     * @param username
     * @return
     */
    public long getUserKeyByName(String username){
        if(username.equals("Alice")){
            return 1;
        }
        if(username.equals("Benny")){
            return 2;
        }
        if(username.equals("Cindy")){
            return 3;
        }

        throw new IndexOutOfBoundsException("Incorrect username.");
    }

    /**Gets a hashtag by name.
     *
     * @param hashtag
     * @return
     */
    public long getHashtagByName(String hashtag){
//        try{
//            MHashtag tag = this.getModel(WebServiceClient.getHashtagByName(hashtag));
//            return tag;
//        }
//        catch(WebRequestException e){
//            System.out.println("Unable to get hashtag.");
//        }
//        return null;

        // FIXME: 2016-04-02
        return 0;
    }
}
