package client.pages.pageInternal.serverClientInteractions;

import server.model.social.MConversation;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MMusicPost;
import server.model.user.UserConversations;
import server.model.user.UserDiaryContent;
import server.model.user.UserUploadedContent;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Kevin Zheng on 2016-03-21.
 */
public class SocialContentTalker extends Talkers{
    private UserConversations uConv;
    private UserUploadedContent uCont;
    private UserDiaryContent uDiary;

    //--Interface Fields
    private List<MConversation> conversations;
    private List<MMusicPost> musicPosts;
    private List<MDiaryPost> diaryPosts;

    //Getters and Setters
    public List<MConversation> getConversations(){
        return conversations;
    }

    public List<MMusicPost> getMusicPosts(){
        return musicPosts;
    }

    public List<MDiaryPost> getDiaryPosts(){
        return diaryPosts;
    }



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
            newConversationList.add(modelStorage.<MConversation>getModel(key));
        }

        this.conversations = newConversationList;
    }
}
