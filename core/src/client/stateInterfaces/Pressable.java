package client.stateInterfaces;

import client.internalExceptions.NoExecutableException;

/**
 * This is the pressable interface.
 * This should be only implemented by the given Performable.
 *
 * Created by Hongyu Wang on 3/12/2016.
 */
public interface Pressable extends Performable{



    /**
     * This will allow one to set the Performable's executable.
     * The executables are classes that stores bundles of logic
     *
     */
    void setExecutable(Executable ex);

    /**
     * This method will make the performable
     * check if the mouse has pressed at their location.
     * @return mouse location matches the component's location
     */
    boolean isPressed();

    /**
     * This is the press method. What this method will do is it will send
     * a new ActionEvent to the actionListener.
     */
    void press();

    void release();
}
