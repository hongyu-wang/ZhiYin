package client.events.executables.internalChanges;

import client.pageStorage.Pages;
import client.singletons.StateManager;

/**
 * Created by Hongyu Wang on 3/21/2016.
 */
public class NoChangeExecutable extends ExecuteChangePage{
    public NoChangeExecutable(Pages page) {
        super(page);
    }
    @Override
    public void execute(){
        StateManager.getInstance().noResetChangeState(page);
    }
}
