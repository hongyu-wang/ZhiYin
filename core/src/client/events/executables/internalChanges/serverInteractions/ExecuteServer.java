package client.events.executables.internalChanges.serverInteractions;

import client.stateInterfaces.Executable;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Hongyu Wang on 4/2/2016.
 */
public interface ExecuteServer extends Executable{
    LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
}
