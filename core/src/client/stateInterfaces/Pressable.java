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
     * This will return the Performable's executable.
     * The executables are classes that store bundles of logic.
     *
     * This is so that no one method becomes cluttered with large amounts of logic and it
     * is instead spread out through several classes
     *
     * @return An Executable for the ActionMonitor to run.
     */
    Executable getExecutable() throws NoExecutableException;

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
     * This is the method that is called whenever the performable
     * is about to get pressed.
     */
    void setAnimation();

    /**
     * This is the press method. What this method will do is it will send
     * a new ActionEvent to the actionListener.
     */
    void press();

    /**
     * This method will make the performable check
     * if the mouse has been released at their location.
     *
     * @return mouse location matches the component's location.
     */
    boolean isReleased();
}
