package tools.serverTools.server;

import server.model.media.MText;
import server.model.structureModels.ServerModel;
import tools.serverTools.databases.VirtualDatabase;
import tools.serverTools.generators.SerialGenerator;
import tools.utilities.Utils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class MockServer {
    private VirtualDatabase database;
    private SerialGenerator generator;

    MockServer(){
        try{
            database = new VirtualDatabase();
        }
        catch(IOException e){
            System.out.print("MockServer Init Fail.");
        }
    }


    public long getSerial(){
        return database.generator.generateSerial();
    }

    /**Returns the user key by the username.
     *
     * @param username
     * @return
     */
    public long getUserKeybyName(String username){
        return database.getUserKeybyName(username);
    }

    /**Returns the requested model from the database.
     *
     * @param key
     * @return
     */
    public ServerModel getModel(long key){
        return database.getModel(key);
    }

    /**Pushes the model into the database.
     *
     * @param model
     */
    public void setModel(ServerModel model){
        database.setModel(model);
        database.getUpdatedKeys().add(model.getKey());
    }

    public List<ServerModel> getUpdates(long size){
        List<Long> updatedKeys = database.getUpdatedKeys();
        List<ServerModel> rList = Utils.newList();
        for(Long key : database.getUpdatedKeys().subList((int)size, updatedKeys.size())){
            rList.add(database.getModel(key));
        }

        return rList;
    }

}
