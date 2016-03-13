package client.events.executables.internalChanges;

import client.stateInterfaces.Executable;

/**
 * This class just tests stuff.
 * This allows to check which button to check.
 *
 * Created by Hongyu Wang on 3/12/2016.
 */
public class TestExecutable implements Executable {
    private String message;
    public TestExecutable(String message){
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }


}
