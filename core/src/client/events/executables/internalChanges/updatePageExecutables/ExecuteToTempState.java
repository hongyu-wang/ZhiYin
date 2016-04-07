package client.events.executables.internalChanges.updatePageExecutables;

import client.pages.State;
import client.pages.friends.Friends2;
import client.pages.other.TransitionState;
import client.pages.other.TransitionType;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/23/2016.
 */
public class ExecuteToTempState implements Executable {
    protected State state, previous;
    protected boolean useBaseTransitionType;
    protected TransitionType base;

    public ExecuteToTempState(State state){
        this(state, TransitionType.NONE);
    }

    public ExecuteToTempState(State state, State previous){
        this.state = state;
        this.previous = previous;
        useBaseTransitionType = false;
    }

    public ExecuteToTempState(State state, TransitionType base) {
        this.state = state;
        this.base = base;
        useBaseTransitionType = true;
    }


    @Override
    public void execute() {
        TransitionType transitionType = useBaseTransitionType ? base : previous.getTransitionType();
        StateManager.getInstance().toTemporaryState(new TransitionState(state, transitionType));
    }
}
