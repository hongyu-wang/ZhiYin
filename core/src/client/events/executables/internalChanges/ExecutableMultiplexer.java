package client.events.executables.internalChanges;

import client.stateInterfaces.Executable;

import java.util.List;

/**
 *
 * Created by Hongyu Wang on 3/15/2016.
 */
public class ExecutableMultiplexer implements Executable {

    private List<Executable> executableList;
    public ExecutableMultiplexer(){
        executableList = tools.utilities.Utils.newList();
    }

    public ExecutableMultiplexer(Executable...executables){
        this();
        for (Executable ex : executables){
            executableList.add(ex);
        }
    }

    public void addExecutable(Executable executable){
        executableList.add(executable);
    }


    @Override
    public void execute() {
        for (Executable ex : executableList){
            ex.execute();
        }
    }
}
