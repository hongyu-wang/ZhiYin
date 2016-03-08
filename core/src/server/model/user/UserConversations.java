package server.model.user;

import server.model.structureModels.ServerModel;

import java.util.List;

/**A model filled with all the conversations and messages between users.
 *
 *      - Messages
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserConversations extends ServerModel {
    /**
     * The list of keys to each conversation.
     */
    List<Long> convoKeys;


    /**Returns the keys to each conversation a user has.
     *
     * @return  The List of keys to each specific conversation.
     */
    public List<Long> getConvoKeys() {
        return convoKeys;
    }

    public void setConvoKeys(List<Long> convoKeys) {
        this.convoKeys = convoKeys;
    }
}
