package client.events.executables.internalChanges;

import client.pages.State;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/23/2016.
 */
public class ExecuteToTempState implements Executable {
    private State state;

    public ExecuteToTempState(State state){
        this.state = state;
    }

    @Override
    public void execute() {
        StateManager.getInstance().toTemporaryState(state);
    }
}
