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
public class ConversationTalker extends Talkers {

    private MConversation conversation;
    private Map<MMessage, MessageHelper> userMessages;

    //--Interface Fields
    private List<MMessage> mMessages;
    private List<User> participants;
    private Map<MMessage, String> messages;
    private Map<MMessage, User> users;
    private boolean seen;


    //Getter and Setters
    public List<MMessage> getAllMMessages(){
        return mMessages;
    }

    public List<User> getParticipants(){
        return participants;
    }

    public String getMessageText(MMessage message){
        return messages.get(message);
    }

    public User getMessageCreator(MMessage message){
        return users.get(message);
    }

    public boolean isSeen(){
        return seen;
    }


    /*------------------------------------------------------------------------*/

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MConversation conversation){
        this.conversation = conversation;

        mMessages = Utils.newList();
        participants = Utils.newList();
        messages = Utils.newMap();
        users = Utils.newMap();
    }

    public void newMessage(String userText){
        MText text = TextManagerFactory.createTextManager().createText(userText, 0);

        MMessage message = MessageManagerFactory.createMessageManager().createMessage(text.getKey(), System.currentTimeMillis(), modelStorage.getMainUser().getKey());

        mMessages.add(message);

        messages.put(message, userText);

        users.put(message, super.getMainUser());
    }

    /*------------------------------------------------------------------------*/


    @Override
    public void pull() {
        super.setWaiting(true);

        for(long key: conversation.getMessageList()){
            modelStorage.requestModelFromServer(MMessage.class.getName(), key);
        }

        for(long key: conversation.getParticipants()){
            modelStorage.requestModelFromServer(User.class.getName(), key);
        }
    }

    @Override
    public void push() {
        while(mMessages.size() > conversation.getMessageList().size()){
            MMessage message = mMessages.get(conversation.getMessageList().size());

            MText text = new MText();
            text.setKey(message.getText());
            text.setType(0);
            text.setText(messages.get(message));

            conversation.getMessageList().add(message.getKey());

            modelStorage.pushModel(text);
            modelStorage.pushModel(message);
        }

        modelStorage.pushModel(conversation);
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

        super.setWaiting(false);
        return true;
    }

    @Override
    public void update(float dt) {
        List<User> newUserList = Utils.newList();
        List<MMessage> newMessageList = Utils.newList();

        Map<MMessage, String> newMessagess = Utils.newMap();
        Map<MMessage, User> newUsers = Utils.newMap();

        //Add Participants
        for(long key: conversation.getParticipants()) {
            newUserList.add(modelStorage.<User>getModel(key));
        }

        //Add Messages
        for(long key: conversation.getMessageList()){
            newMessageList.add(modelStorage.<MMessage>getModel(key));
        }

        for(MMessage message: mMessages){
            updateMessages(message);
        }
    }

    private void updateMessages(MMessage message){
        if(message == null){
            return;
        }
        if(!userMessages.keySet().contains(message)){
            newHelper(message);
        }
        else{
            oldHelper(message);
        }
    }

    private void newHelper(MMessage message){
        MessageHelper messageHelper = new MessageHelper();
        userMessages.put(message, messageHelper);

        messageHelper.init(message);
        messageHelper.pull();
    }


    private void oldHelper(MMessage message){
        MessageHelper messageHelper = userMessages.get(message);

        if(messageHelper.isWaiting()){
            messageHelper.update(0);
        }
        else{
            messageHelper.pull();
        }

        if(messageHelper.isUpdated()){
            messages.put(message, messageHelper.message);
            users.put(message, messageHelper.creator);
        }
    }


    private class MessageHelper extends Talkers{
        private MMessage mMessage;
        private MText text;

        public String message;
        public User creator;

        @Deprecated
        @Override
        public void init() {

        }

        public void init(MMessage message){
            this.mMessage = message;
        }


        @Override
        public void pull() {
            super.setWaiting(true);

            modelStorage.requestModelFromServer(MText.class.getName(), mMessage.getText());
            modelStorage.requestModelFromServer(User.class.getName(), mMessage.getCreator());
        }

        @Override
        public void push() {
            return;
        }

        @Override
        public boolean isUpdated() {
            if(text == null){
                return false;
            }

            if(creator == null){
                return false;
            }

            super.setWaiting(false);

            return true;
        }

        @Override
        public void update(float dt) {
            text = modelStorage.getModel(mMessage.getText());
            creator = modelStorage.getModel(mMessage.getCreator());

            if(text != null)
                message = text.getText();
        }
    }
}

