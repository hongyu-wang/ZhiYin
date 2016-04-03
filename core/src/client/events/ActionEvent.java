package client.events;

import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.internalExceptions.NoExecutableException;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Performable;


/**
 * This is an ActionEvent class. This is mainly a marker class with only one method: Get source.
 *
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class ActionEvent {


    /**
     * This is the source of the ActionEvent.
     */
    private final Performable source;

    /**
     * This is the primary constructor of the ActionEvent
     * @param performer the component which "performs" the action.
     */
    public ActionEvent(Performable performer){

        source = performer;
    }

    /**
     * This will return the Performable source into the action listener in order to perform
     * some event.
     * @return The source of the event.
     */
    public Performable getSource() {
        return source;
    }




}
