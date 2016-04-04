package tools.serverTools.server;

import server.model.media.MText;
import server.model.social.MConversation;
import server.model.structureModels.ServerModel;
import tools.serverTools.databases.VirtualDatabase;
import tools.serverTools.generators.SerialGenerator;
import tools.utilities.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if(model instanceof MConversation){
            ServerModel databaseModel = database.getModel(model.getKey());
            if(databaseModel != null){
                MConversation convo1 = (MConversation)model;
                MConversation convo2 = (MConversation)databaseModel;

                ((MConversation) model).setMessageList(union(convo1.getMessageList(), convo2.getMessageList()));
            }
        }

        database.setModel(model);
    }

    private <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    
    public List<Long> getUpdates(){
        return database.getUpdatedKeys();
    }

}
