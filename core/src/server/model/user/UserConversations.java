package server.model.user;

import server.model.social.Conversation;

import java.util.List;

/**A model filled with all the conversations and messages between users.
 *
 *      - Messages
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserConversations {
    List<String> convoKeys;
    List<Conversation> convo;
    //TODO Examine design here.


    /**Returns the keys to each conversation a user has.
     *
     * @return  The List of keys to each specific conversation.
     */
    public List<String> getConvoKeys() {
        return convoKeys;
    }

    /**Returns the list of conversations the user has.
     *
     * @return  The list of all user conversations in order of most recent to
     *          least recent.
     */
    public List<Conversation> getConversations() {
        return convo;
    }

    public void setConvoKeys(List<String> convoKeys) {
        this.convoKeys = convoKeys;
    }
    public void setConversations(List<Conversation> convo) {
        this.convo = convo;
    }
}
