package tools.serverTools.databases;

import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import driver.GameLoop;
import server.model.media.MHashtag;
import server.model.serverKey.MServerKey;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import server.services.factories.MusicHashtagManagerFactory;
import server.webservices.PostObject;
import server.webservices.RequestObject;
import tools.serverTools.generators.SerialGenerator;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**A storage object of all model types the user client will need.
 *
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public class LocalDatabase {
    private long user;
    private int pullCount;
    private Set<Long> pulledKeys;
    private Map<Long, ServerModel> models;
    private Map<String, Long> hashtag_key;
    private Map<String, Long> username_key;
    private SerialGenerator generator;

    public static String ipAddress = "localhost";

    private String[] hashtags = {
            "#Sorry",
            "#MissingU",
            "#Weeknd",
            "#RnB",
            "#Pop",
            "#M5",
            "#Bieber",
            "#Kanye",
            "#Ed",
            "#LoveYourself"
    };

    private String[] usernames = {
            "Alice",
            "Benny",
            "Cindy"
    };

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
        try{
            return (MServerKey) models.get(this.getMainUser().getKeyState());
        }
        catch(NullPointerException e){
            return null;
        }
    }

    LocalDatabase(){
        pullCount = 0;
        models = Utils.newMap();
        hashtag_key = Utils.newMap();
        username_key = Utils.newMap();
        pulledKeys = new ConcurrentSkipListSet<>();
//        unassignedKeys = new ArrayList<Long>();
        initStringMaps();
//        try {
//            models = new VirtualDatabase().data;
//        }
//        catch(Exception e){
//            System.out.println("Fuck");
//        }
    }

    private void initStringMaps(){
        long i = 1L;
        for(String name: usernames){
            username_key.put(name, i);
            i++;
        }

        i = 20000L;
        for(String tag: hashtags){
            hashtag_key.put(tag, i);
            i++;
        }
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
        if(!GameLoop.INITIALPUSH){
            return;
        }
        if(this.getKeyState() != null) {
            modelList.add(this.getKeyState());
        }
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
        if(pullCount == serverKeys.length){
            TalkerFactory.getServerTalker().notWaiting();
        }else{
            pullCount = serverKeys.length;
        }
    }

    public void removeKeyFromServer(long key){
        models.remove(key);
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
        if(username_key.containsKey(username)){
            return username_key.get(username);
        }
        throw new IndexOutOfBoundsException("Incorrect username.");
    }

    public Set<String> getHashtags(){
        return hashtag_key.keySet();
    }

    public Set<String> getUsernames(){
        return username_key.keySet();
    }


    /**Gets a hashtag by name.
     *
     * @param hashtag
     * @return
     */
    public long getHashtagByName(String hashtag){
        if(hashtag_key.containsKey(hashtag)){
            return hashtag_key.get(hashtag);
        }
        else{
//            return newHashtag(hashtag);
            throw new IndexOutOfBoundsException("Incorrect username.");
        }
    }

    private long newHashtag(String hashtag){
        MHashtag newHashtag = MusicHashtagManagerFactory.createMusicHashtagManager().createNewHashTag(hashtag);
        newHashtag.setKey(generateKey());
        hashtag_key.put(newHashtag.getHashtagName(), newHashtag.getKey());
        List<ServerModel> pushList = Utils.newList();
        pushList.add(newHashtag);
        this.pushModel(pushList);

        return newHashtag.getKey();
    }

}
