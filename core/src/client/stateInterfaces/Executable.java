package client.stateInterfaces;

import client.tools.Constants;

/**
 * This is the primary "Executable" interface.
 * This interface will contain one method: Execute.
 * Execute is a class that contains the implementation of action of all things that create actions.
 *
 * Created by Hongyu Wang on 3/10/2016.
 */
public interface Executable extends Constants {

    /**
     * This is the default execute method that all
     * executables should have.
     */
    void execute();


}
