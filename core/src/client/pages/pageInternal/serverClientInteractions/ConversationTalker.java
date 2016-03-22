package client.pages.pageInternal.serverClientInteractions;

import server.model.social.MConversation;
import server.model.user.UserConversations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-21.
 */
public class ConversationTalker extends Talkers{
    private UserConversations uConv;

    //--Interface Fields
    public List<MConversation> conversations;


    /*------------------------------------------------------------------------*/

    @Override
    public void init() {
        user = modelStorage.getMainUser();
        uConv = modelStorage.getModel(user.getConversations());
    }

    /*------------------------------------------------------------------------*/



    @Override
    public void pull() {

        for(long convoKey: uConv.getConvoKeys()){
            modelStorage.requestModelFromServer(
                    UserConversations.class.getName(),
                    convoKey);
        }

    }

    @Override
    public void push() {

        //Set
        for(MConversation conversation: conversations){
            if(!uConv.getConvoKeys().contains(conversation.getKey()))
                uConv.getConvoKeys().add(conversation.getKey());
        }

        //Push
        modelStorage.pushModel(user);
    }

    @Override
    public boolean isUpdated() {
        return false;
    }

    @Override
    public void update(float dt) {
        List<MConversation> newConversationList = new ArrayList<>();

        for(long key: uConv.getConvoKeys()){
            newConversationList.add(modelStorage.getModel(key));
        }

        this.conversations = newConversationList;
    }
}
