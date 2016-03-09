package server.services.socialService;

import server.model.media.MMusic;
import server.model.media.MText;
import server.model.social.MMessage;
import tools.utilities.Utils;

/**
 * Created by Hairuo on 2016-03-06.
 */
public class MessageManagerImplementation implements MessageManager{
    /**
     * Creates a message
     *
     * @param text the text contained in the message
     * @param timeStamp the time the message was created
     * @param creator the id of the user that created it
     * @return a message containing the inputed data
     */
    @Override
    public MMessage createMessage(MText text, long timeStamp, long creator){
        MMessage message = new MMessage();
        message.setCreator(creator);
        message.setText(text);
        message.setTimeStamp(timeStamp);
        message.setSeenBy(Utils.newList());
        return message;
    }

    /**
     * Retrieves a message from the database
     *
     * @param key id of the message to be retrieved
     * @return the message associated with the id
     */
    @Override
    public MMessage getMessage(long key){
        //TODO Implement this stuff
        return null;
    }

    /**
     * Edits the text of a message
     *
     * @param text the new text
     * @return the edited message
     */
    @Override
    public MMessage editMessage(MText text, MMessage message){
        message.setText(text);
        return message;

    }

}