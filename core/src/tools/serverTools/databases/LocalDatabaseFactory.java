package tools.serverTools.databases;

import server.model.user.User;
import tools.serverTools.databases.LocalDatabase;

/**
 * Created by Kevin Zheng on 2016-03-19.
 */
public class LocalDatabaseFactory {
    private static LocalDatabase localDatabase;

    private LocalDatabaseFactory(){}

    public static LocalDatabase createModelStorage(){
        if(localDatabase == null){
            localDatabase = new LocalDatabase();
        }
        return localDatabase;
    }

    public static LocalDatabase createModelStorage(User user){
        if(localDatabase == null){
            localDatabase = new LocalDatabase(user);
        }
        return localDatabase;
    }
}
