package client.events.executables.internalChanges.schmoferMusicExecutable;

import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteSetSave implements Executable{
    private ExecuteRecord executeRecord;

    public ExecuteSetSave(ExecuteRecord ex){
        executeRecord = ex;
    }

    @Override
    public void execute() {
        executeRecord.setSave();
    }
}
