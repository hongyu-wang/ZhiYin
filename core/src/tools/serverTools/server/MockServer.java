package tools.serverTools.server;

import server.model.structureModels.ServerModel;
import tools.serverTools.databases.VirtualDatabase;
import tools.serverTools.generators.SerialGenerator;

import java.io.IOException;

/**
 * Created by Kevin Zheng on 2016-03-09.
 */
public class MockServer {
    private VirtualDatabase database;
    private SerialGenerator generator;

    public MockServer(){
        try{
            database = new VirtualDatabase();
        }
        catch(IOException e){
            System.out.print("MockServer Init Fail.");
        }
        generator = SerialGenerator.getGenerator();
    }

    public long getSerial(){
        return generator.generateSerial();
    }

    public ServerModel getModel(long key){
        return database.getModel(key);
    }

    public void setModel(ServerModel model){
        database.setModel(model);
    }

}
