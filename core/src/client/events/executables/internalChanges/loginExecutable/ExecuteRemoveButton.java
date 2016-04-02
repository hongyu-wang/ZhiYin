package client.events.executables.internalChanges.loginExecutable;

import client.component.basicComponents.Button;
import client.stateInterfaces.Executable;

/**
 * Created by Hongyu Wang on 3/28/2016.
 */
public class ExecuteRemoveButton implements Executable{

    private Button button;

    public ExecuteRemoveButton(Button button){
        this.button = button;
    }

    @Override
    public void execute() {
        button.setBounds(-750, -1334, 123, 1234);
    }
}
