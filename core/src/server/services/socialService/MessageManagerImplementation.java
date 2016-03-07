package server.services.socialService;

import server.model.media.Text;
import server.model.social.Message;
import tools.Utils;

import javax.rmi.CORBA.Util;

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
    public Message createMessage(Text text, long timeStamp, long creator){
        Message message = new Message();
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
    public Message retrieveMessage(long key){
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
    public Message editMessage(Text text, Message message){
        message.setText(text);
        return message;

    }
}
