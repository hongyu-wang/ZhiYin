package server.model.user;

import server.model.social.Conversation;
import tools.ServiceList;
import tools.ServiceTable;

/**A model filled with all the conversations and messages between users.
 *
 *      - Messages
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserConversations {
    ServiceList<String> convoKeys;
    ServiceList<Conversation> convo;
    //TODO Examine design here.


    /**Returns the keys to each conversation a user has.
     *
     * @return  The ServiceList of keys to each specific conversation.
     */
    public ServiceList<String> getConvoKeys() {
        return convoKeys;
    }

    /**Returns the list of conversations the user has.
     *
     * @return  The list of all user conversations in order of most recent to
     *          least recent.
     */
    public ServiceList<Conversation> getConversations() {
        return convo;
    }

    public void setConvoKeys(ServiceList<String> convoKeys) {
        this.convoKeys = convoKeys;
    }
    public void setConversations(ServiceList<Conversation> convo) {
        this.convo = convo;
    }
}
