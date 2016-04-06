package client.events.executables.internalChanges.updatePageExecutables;

import client.pages.State;
import client.pages.other.TransitionState;
import client.singletons.StateManager;

/**
 * Created by Hongyu Wang on 4/6/2016.
 */
public class ExecuteToTempStateVertical extends ExecuteToTempState{
    public ExecuteToTempStateVertical(State state, int dir) {
        super(state, dir);
    }

    @Override
    public void execute() {
        StateManager.getInstance().toTemporaryState(new TransitionState(state, dir, false));
    }
}
