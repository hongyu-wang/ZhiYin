package client.events.executables.internalChanges.updatePageExecutables;

import client.pages.State;
import client.pages.other.TransitionState;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/23/2016.
 */
public class ExecuteToTempState implements Executable {
    protected State state;
    protected int dir;
    public ExecuteToTempState(State state){
        this(state, 1);
    }


    public ExecuteToTempState(State state, int dir){
        this.state = state;
        this.dir = dir;
    }


    @Override
    public void execute() {
        StateManager.getInstance().toTemporaryState(new TransitionState(state, dir));
    }
}
