package client.events.executables.internalChanges.updatePageExecutables;

import client.pages.State;
import client.pages.other.TransitionState;
import client.pages.other.TransitionType;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;

/**
 *
 * Created by Hongyu Wang on 3/23/2016.
 */
public class ExecuteToTempState implements Executable {
    protected State state;


    public ExecuteToTempState(State state){
        this.state = state;  }


    @Override
    public void execute() {
        TransitionType transitionType = state.getTransitionType();
        StateManager.getInstance().toTemporaryState(
                new TransitionState(state, transitionType));
    }
}
