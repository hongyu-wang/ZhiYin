package client.events.executables.internalChanges.serverInteractions;

import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Executable;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Kevin Zheng on 2016-04-02.
 */
public abstract class ExecuteUpdate implements ExecuteServer {
    public ExecuteUpdate(){
        TalkerFactory.getServerTalker().addExecutable(this);
    }

}
