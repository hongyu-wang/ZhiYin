package server.services.interfaces.models;

import server.model.social.MMessage;

/**
 * Created by Hairuo on 2016-03-06.
 */
public interface MessageManager {

    /**
     * Creates a message
     *
     * @param text      the text contained in the message
     * @param timeStamp the time the message was created
     * @param creator   the id of the user that created it
     * @return a message containing the inputed data
     */
    public MMessage createMessage(long text, long timeStamp, long creator, long audio);

    /**
     * Edits the text of a message
     *
     * @param text the new text
     * @return the edited message
     */
    public MMessage editMessage(long text, MMessage message);


}

