package client.pages.pageInternal.serverClientInteractions;

import server.model.social.MConversation;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MMusicPost;
import server.model.user.User;
import server.model.user.UserConversations;
import server.model.user.UserDiaryContent;
import server.model.user.UserUploadedContent;
import server.services.factories.ConversationManagerFactory;
import tools.utilities.Utils;

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
        uConv = modelStorage.getModel(super.getMainUser().getConversations());
    }

    public void addNewConversation(List<User> friends){
        List<Long> friendKeys = Utils.newList();

        for(User friend: friends){
            friendKeys.add(friend.getKey());
        }

        MConversation conversation = ConversationManagerFactory.createConversationManager().createConversation(friendKeys);


        conversations.add(conversation);
    }

    public void addNewMusicPost(){}

    public void addNewDiaryPost(){}


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
        modelStorage.pushModel(uConv);
    }

    @Override
    public boolean isUpdated() {

        //Lists
        if(conversations == null){
            return false;
        }
        if(musicPosts == null){
            return false;
        }
        if(diaryPosts == null){
            return false;
        }

        //Entries
        for(MConversation entry: conversations){
            if(entry == null){
                return false;
            }
        }
        for(MMusicPost entry: musicPosts){
            if(entry == null){
                return false;
            }
        }
        for(MDiaryPost entry: diaryPosts){
            if(entry == null){
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(float dt) {

        List<MConversation> newConversationList = Utils.<MConversation>newList();
        List<MMusicPost> newMusicList = Utils.<MMusicPost>newList();
        List<MDiaryPost> newDiaryList = Utils.<MDiaryPost>newList();

        for(long key: uConv.getConvoKeys()){
            newConversationList.add(modelStorage.<MConversation>getModel(key));
        }

        for(long key: uCont.getPostKeys()){
            newMusicList.add(modelStorage.<MMusicPost>getModel(key));
        }

        for(long key: uDiary.getDiaryKeys()){
            newDiaryList.add(modelStorage.<MDiaryPost>getModel(key));
        }

        this.conversations = newConversationList;
        this.musicPosts = newMusicList;
        this.diaryPosts = newDiaryList;
    }
}
