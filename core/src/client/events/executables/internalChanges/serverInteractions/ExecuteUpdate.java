package client.events.executables.internalChanges.serverInteractions;

import client.stateInterfaces.Executable;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public interface ExecuteUpdate extends Executable {
    LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
}
