package client.events.executables.internalChanges;

import client.component.basicComponents.CommentWindow;
import client.pageStorage.Pages;
import client.pages.State;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/21/2016.
 */
public class AddPane implements Executable {
    private State state;
    public AddPane(State state){
        this.state = state;
    }

    @Override
    public void execute() {
        state.getStage().addActor(new CommentWindow().getWindow());
    }
}
