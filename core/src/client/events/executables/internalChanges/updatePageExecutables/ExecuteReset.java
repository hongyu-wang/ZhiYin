package client.events.executables.internalChanges.updatePageExecutables;

import client.pages.State;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteReset implements Executable {
    private State state;
    public ExecuteReset(State state){
        this.state = state;
    }

    @Override
    public void execute() {
        state.reset();
    }
}
