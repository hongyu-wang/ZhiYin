package client.stateInterfaces;

import client.internalExceptions.NoExecutableException;

/**
 * This interface will MARK all classes that can perform events.
 *
 * Examples of this as of now would be buttons.
 *
 * The only method would be the getter for the relevant executable within the performable.
 *
 *
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public interface Performable {

    /**
     * This will return the Performable's executable.
     * The executables are classes that store bundles of logic.
     *
     * This is so that no one method becomes cluttered with large amounts of logic and it
     * is instead spread out through several classes
     *
     * @return An Executable for the ActionMonitor to run.
     */
    Executable getExecutable() throws NoExecutableException;

}
