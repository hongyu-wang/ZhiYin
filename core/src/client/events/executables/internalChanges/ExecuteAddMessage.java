package client.events.executables.internalChanges;

import client.component.basicComponents.ScrollTable;
import client.pages.friends.Friends2;
import client.pages.friends.boxes.MessageBox;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

/**
 *
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteAddMessage implements Executable{

    private Friends2 friend2;

    public ExecuteAddMessage(Friends2 friend2){
        this.friend2 = friend2;
    }


    @Override
    public void execute() {
        ScrollPane scrollpane = friend2.getScrollpane();
        friend2.addMessage(new MessageBox(friend2.getMessage(), 1));
        scrollpane.scrollTo(0, 0, scrollpane.getWidth(), scrollpane.getHeight()+2000);
    }
}
