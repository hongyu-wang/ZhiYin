package client.events.executables.internalChanges.updatePageExecutables;

import client.pageStorage.Pages;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;

/**
 *
 * This is the ExecuteChangePage class.
 *
 * This is the executable that should be declared when one wants to change
 * into a specific enumeration.
 *
 * Created by Hongyu Wang on 3/11/2016.
 */
public class ExecuteChangePage implements Executable{
    protected Pages page;

    public ExecuteChangePage(Pages page){
        this.page = page;
    }

    @Override
    public void execute() {
        StateManager.getInstance().changeState(page);

    }
}
