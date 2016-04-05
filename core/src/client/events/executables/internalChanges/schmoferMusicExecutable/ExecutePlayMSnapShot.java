package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;
import server.model.media.MSnapShot;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by Kevin Zheng on 2016-04-05.
 */
public class ExecutePlayMSnapShot implements Executable {
    private long snapShot;

    public ExecutePlayMSnapShot(MSnapShot snapShot) {
        this.snapShot = snapShot.getKey();
    }

    @Override
    public void execute() {
        MSnapShot snapShot = LocalDatabaseFactory.createLocalDatabase().getModel(this.snapShot);

    }
}
