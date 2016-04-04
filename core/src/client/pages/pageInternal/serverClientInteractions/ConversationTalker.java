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
    private Map<Long, ConversationHelper> userConversations = Utils.newMap();

    private ConversationHelper currentConversation;

    //Getter and Setters
    public List<MMessage> getAllMMessages(){
        return currentConversation.getAllMMessages();
    }

    public List<User> getParticipants(){
        return currentConversation.getParticipants();
    }

    public String getMessageText(MMessage message){
        return currentConversation.getMessageText(message);
    }

    public User getMessageCreator(MMessage message){
        return currentConversation.getMessageCreator(message);
    }

    public boolean isSeen(){
        return currentConversation.isSeen();
    }

    @Deprecated
    @Override
    public void init() {

    }

    public void init(MConversation conversation){
        if(userConversations.containsKey(conversation.getKey())){
            ConversationHelper helper = userConversations.get(conversation.getKey());
            currentConversation = helper;
            currentConversation.conversation = conversation;
        }
        else{
            currentConversation = new ConversationHelper();
            currentConversation.init(conversation);

            userConversations.put(conversation.getKey(), currentConversation);
        }
    }

    public void addNewMessage(String userText){
        currentConversation.newMessage(userText);
    }



    @Override
    public void pull() {
        currentConversation.pull();
    }

    @Override
    public void push() {
        currentConversation.push();
    }

    @Override
    public boolean isUpdated() {
        return currentConversation.isUpdated();
    }

    @Override
    public void update(float dt) {
        currentConversation.update(dt);
    }

    public boolean isWaiting(){
        return currentConversation.isWaiting();
    }





    private class ConversationHelper extends Talkers{
        private MConversation conversation;
        private Map<Long, MessageHelper> userMessages = Utils.newMap();

        //--Interface Fields
        private List<MMessage> mMessages;
        private List<User> participants;
        private Map<Long, String> messages;
        private Map<Long, User> users;
        private boolean seen;


        //Getter and Setters
        public List<MMessage> getAllMMessages(){
            return mMessages;
        }

        public List<User> getParticipants(){
            return participants;
        }

        public String getMessageText(MMessage message){
            return messages.get(message.getKey());
        }

        public User getMessageCreator(MMessage message){
            return users.get(message.getKey());
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

            MMessage message = MessageManagerFactory.createMessageManager().createMessage(text.getKey(), System.currentTimeMillis(), localDatabase.getMainUser().getKey(), -1L);

            MessageHelper messageHelper = new MessageHelper();

            messageHelper.init(message);

            userMessages.put(message.getKey(), messageHelper);

            conversation.getMessageList().add(message.getKey());

            mMessages.add(message);

            messages.put(message.getKey(), userText);

            users.put(message.getKey(), super.getMainUser());
        }

    /*------------------------------------------------------------------------*/


        @Override
        public void pull() {
            super.setWaiting(true);

            for(long key: conversation.getMessageList()){
                localDatabase.requestModelFromServer(key);
            }

            for(long key: conversation.getParticipants()){
                localDatabase.requestModelFromServer(key);
            }
        }

        @Override
        public void push() {
//            for (MMessage message : mMessages) {
//                if(message == null){
//                    continue;
//                }
//
//                MText text = new MText();
//                text.setKey(message.getText());
//                text.setType(0);
//                text.setText(messages.get(message.getKey()));
//
//
//                localDatabase.pushModel(text);
//                localDatabase.pushModel(message);
//            }
//
//            localDatabase.pushModel(conversation);
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

            if(users == null){
                return false;
            }

            for(MMessage message: mMessages){
                boolean updated = userMessages.get(message.getKey()).isUpdated();
                if(!updated){
                    return false;
                }
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
                newUserList.add(localDatabase.<User>getModel(key));
            }

            //Add Messages
            for(long key: conversation.getMessageList()){
                newMessageList.add(localDatabase.<MMessage>getModel(key));
            }

            mMessages = newMessageList;
            participants = newUserList;

            for(MMessage message: mMessages){
                updateMessages(message);
            }
        }

        //Why
        private void updateMessages(MMessage message){
            if(message == null){
                return;
            }
            if(!userMessages.keySet().contains(message.getKey())){
                newHelper(message);
            }
            else{
                oldHelper(message);
            }
        }

        private void newHelper(MMessage message){
            MessageHelper messageHelper = new MessageHelper();
            userMessages.put(message.getKey(), messageHelper);

            messageHelper.init(message);
            messageHelper.pull();
        }


        private void oldHelper(MMessage message){
            MessageHelper messageHelper = userMessages.get(message.getKey());

            if(messageHelper.isWaiting()){
                messageHelper.update(0);
            }
            else{
                messageHelper.pull();
            }

            if(messageHelper.isUpdated()){
                String stringText;
                if (messageHelper.message == null)
                    stringText = "";
                else{
                    stringText = messageHelper.message;
                }
                messages.put(message.getKey(), stringText);
                users.put(message.getKey(), messageHelper.creator);
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

                localDatabase.requestModelFromServer(mMessage.getText());
                localDatabase.requestModelFromServer(mMessage.getCreator());
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
                text = localDatabase.getModel(mMessage.getText());
                creator = localDatabase.getModel(mMessage.getCreator());

                if(text != null)
                    message = text.getText();
            }
        }
    }

}

