package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import server.model.media.MAudio;
import server.model.media.MHashtag;
import server.model.media.MImage;
import server.model.media.MMusic;
import server.model.user.*;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class VeryBeginningIntializer extends Talkers{

    public VeryBeginningIntializer(String username){
        modelStorage.loginUser("Alice");
    }

    @Override
    public void pull() {
        long key = 1;

        //Users
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(User.class.getName(), key++);

        //UserContents
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(UserProfile.class.getName(), key++);
            modelStorage.requestModelFromServer(UserConversations.class.getName(), key++);
            modelStorage.requestModelFromServer(UserActivityLog.class.getName(), key++);
            modelStorage.requestModelFromServer(UserUploadedContent.class.getName(), key++);
            modelStorage.requestModelFromServer(UserDiaryContent.class.getName(), key++);
        }

        //Images
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MImage.class.getName(), key++);

        //Audio
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MAudio.class.getName(), key++);

        //Music
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MMusic.class.getName(), key++);

        //Hashtag
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(MHashtag.class.getName(), key++);

        totalmodels = key;
    }

    @Override
    public void push() {
        return;
    }

    @Override
    public boolean isUpdated() {
        return super.checkUpdated();
    }


    @Override
    public void update(float dt) {
        return;
    }
}
