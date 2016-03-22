package client.pages.pageInternal.serverClientInteractions;

import server.model.media.MText;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.user.User;
import server.services.factories.MessageManagerFactory;
import server.services.factories.TextManagerFactory;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-21.
 */
public class MessagesTalker extends Talkers {

    private MConversation conversation;

    //--Interface Fields
    public List<MMessage> mMessages;
    public List<User> participants;
    public Map<MMessage, String> messages;
    public Map<MMessage, User> users;
    public boolean seen;

    /*------------------------------------------------------------------------*/

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MConversation conversation){
        this.conversation = conversation;
    }


    /*------------------------------------------------------------------------*/


    @Override
    public void pull() {
        for(long key: conversation.getMessageList()){
            modelStorage.requestModelFromServer(MMessage.class.getName(), key);
        }

        for(long key: conversation.getParticipants()){
            modelStorage.requestModelFromServer(User.class.getName(), key);
        }
    }

    @Override
    public void push() {
        while(messages.size() > conversation.getMessageList().size()){

            MText text = TextManagerFactory.createTextManager().createText(messages.get(conversation.getMessageList().size()), 0);

            MMessage message = MessageManagerFactory.createMessageManager().createMessage(text.getKey(), System.currentTimeMillis(), modelStorage.getMainUser().getKey());

            conversation.getMessageList().add(message.getKey());

            modelStorage.pushModel(text);
            modelStorage.pushModel(message);
            modelStorage.pushModel(conversation);
        }
    }

    @Override
    public boolean isUpdated() {
        if(participants == null){
            return false;
        }

        for(User user: participants){
            if(user == null){
                return false;
            }
        }

        if(mMessages == null){
            return false;
        }

        for(MMessage message: mMessages){
            if(message == null)
                return false;
        }

        if(messages == null){
            return false;
        }

        for(MMessage message: mMessages){
            if(messages.get(message) == null )
                return false;
        }

        if(users == null){
            return false;
        }

        for(MMessage message: mMessages){
            if(users.get(message) == null)
                return false;
        }

        return true;
    }

    @Override
    public void update(float dt) {
        List<User> newUserList = Utils.newList();
        List<MMessage> newMessageList = Utils.newList();

        Map<MMessage, String> newMessagess = Utils.newMap();
        Map<MMessage, User> newUsers = Utils.newMap();

        for(long key: conversation.getParticipants()) {
            newUserList.add(modelStorage.getModel(key));
        }

        for(long key: conversation.getMessageList()){
            newMessageList.add(modelStorage.<MMessage>getModel(key));
        }

        for(MMessage message: mMessages){
            if(message == null){

            }
        }
    }
}
