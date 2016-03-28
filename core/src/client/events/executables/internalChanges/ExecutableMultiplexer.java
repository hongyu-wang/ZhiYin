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

    public void addExecutable(Executable executable){
        executableList.add(executable);
    }


    public Executable [] getAllChildren(){
        return executableList.toArray(new Executable[executableList.size()]);
    }



    @Override
    public void execute() {
        for (Executable ex : executableList){
            ex.execute();
        }
    }
}
