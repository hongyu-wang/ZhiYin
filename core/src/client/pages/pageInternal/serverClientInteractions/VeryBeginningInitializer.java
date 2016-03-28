package client.pages.pageInternal.serverClientInteractions;

import server.model.media.MHashtag;
import server.model.media.MImage;
import server.model.social.MConversation;
import server.model.user.*;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class VeryBeginningInitializer extends Talkers{

    /*------------------------------------------------------------------------*/

    @Override
    @Deprecated
    public void init() {

    }

    public void init(String username){
        modelStorage.loginUser(username);

        TalkerFactory.getFriendTalker().init();
    }

    /*------------------------------------------------------------------------*/



    @Override
    public void pull() {
        super.setWaiting(true);

        long key = 1;

        //Users
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(User.class.getName(), key++);
        }

        //UserContents
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(UserProfile.class.getName(), key++);
            modelStorage.requestModelFromServer(UserConversations.class.getName(), key++);
            modelStorage.requestModelFromServer(UserActivityLog.class.getName(), key++);
            modelStorage.requestModelFromServer(UserUploadedContent.class.getName(), key++);
            modelStorage.requestModelFromServer(UserDiaryContent.class.getName(), key++);
        }

        //Images
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(MImage.class.getName(), key++);

        //Audio
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MAudio.class.getName(), key++);

        //Music
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MMusic.class.getName(), key++);

        //Hashtag
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(MHashtag.class.getName(), key++);


        for(int i = 0; i < 3 ; i++){
            modelStorage.requestModelFromServer(MConversation.class.getName(), key++);
        }

        totalOriginalModels = key;
    }

    @Override
    public void push() {
        return;
    }

    @Override
    public boolean isUpdated() {
        boolean initialUpdate = super.checkOriginalUpdate();

        if(!initialUpdate){
            return false;
        }

        boolean updateFriend = TalkerFactory.getFriendTalker().isUpdated();
        boolean updateProfiles = TalkerFactory.getProfileTalker().isUpdated();

        boolean[] talkers = {
                updateFriend,
                updateProfiles
        };

        for(boolean truth: talkers){
            if(!truth){
                return false;
            }
        }

        super.setWaiting(initialUpdate);
        return initialUpdate;
    }

    @Override
    public void update(float dt) {
        if(!super.checkOriginalUpdate()){
            return;
        }

        talkerInit();
    }

    private void talkerInit(){
        FriendTalker ft = TalkerFactory.getFriendTalker();
        ProfileTalker pt = TalkerFactory.getProfileTalker();
        ft.update(0);
        for(User friend: ft.getAllFriends()){
            pt.init(friend);
            pt.update(0);
        }
    }
}
