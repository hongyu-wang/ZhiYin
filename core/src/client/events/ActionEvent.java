package client.events;

import client.stateInterfaces.Performable;
import client.stateInterfaces.Pressable;

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
    private final Pressable source;

    /**
     * This is the primary constructor of the ActionEvent
     * @param performer the component which "performs" the action.
     */
    public ActionEvent(Pressable performer){
        source = performer;
    }

    /**
     * This will return the Performable source into the action listener in order to perform
     * some event.
     * @return The source of the event.
     */
    public Pressable getSource() {
        return source;
    }

}
