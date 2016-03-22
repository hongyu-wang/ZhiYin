package client.pages.pageInternal.serverClientInteractions;

import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.user.User;
import server.model.user.UserConversations;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-21.
 */
public class ConversationTalker extends Talkers{
    private static final int unreadTheirs = 0;

    private static final int readTheirs = 1;

    private static final int unreadYours = 2;

    private static final int readYours = 3;

    private MConversation conversation;

    public List<MMessage> messages;

    public ConversationTalker(long key){
        conversation = modelStorage.getModel(key);
    }

    @Override
    public void pull() {
        User user = modelStorage.getMainUser();

        UserConversations uConv = modelStorage.getModel(user.getConversations());


    }

    @Override
    public void push() {

    }

    @Override
    public boolean isUpdated() {
        return false;
    }

    @Override
    public void update(float dt) {
        for(long key: conversation.getMessageList())
            messages.add(modelStorage.getModel(key));
    }
}
