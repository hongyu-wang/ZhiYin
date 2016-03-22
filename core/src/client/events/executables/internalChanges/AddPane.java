package client.events.executables.internalChanges;

import client.component.basicComponents.CommentWindow;
import client.pageStorage.Pages;
import client.pages.State;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/21/2016.
 */
public class AddPane implements Executable {
    private Pages page;
    public AddPane(Pages page){
        this.page = page;
    }

    @Override
    public void execute() {
        page.getStateReference().getStage().addActor(new CommentWindow().getWindow());
    }
}
