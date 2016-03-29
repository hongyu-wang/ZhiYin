package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import driver.GameLoop;
import server.model.media.MImage;
import server.model.user.*;
import server.services.factories.ImageManagerFactory;

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
            modelStorage.requestModelFromServer(key++);
        }

        //UserContents
        for(int i = 0; i < 3; i++) {
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
            modelStorage.requestModelFromServer(key++);
        }

        //Images
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(key++);

        //Audio
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MAudio.class.getName(), key++);

        //Music
//        for(int i = 0; i < 3; i++)
//            modelStorage.requestModelFromServer(MMusic.class.getName(), key++);

        //Hashtag
        for(int i = 0; i < 3; i++)
            modelStorage.requestModelFromServer(key++);


        for(int i = 0; i < 3 ; i++){
            modelStorage.requestModelFromServer(key++);
        }

        totalOriginalModels = key;
    }

    @Override
    public void push() {
        if(GameLoop.ISMAC){
            return;
        }
        MImage image1 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Alice_After_The_War.png");
        MImage image2 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Benny_After_The_War.png");
        MImage image3 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Cindy_After_The_War.png");

        image1.setKey(-13L);
        image2.setKey(-12L);
        image3.setKey(-11L);

        image1.setName("Alice's Profile");
        image2.setName("Benny's Profile");
        image3.setName("Cindy's Profile");

        modelStorage.pushModel(image1);
        modelStorage.pushModel(image2);
        modelStorage.pushModel(image3);

        MImage image4 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Alice_After_The_War.png");
        MImage image5 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Benny_After_The_War.png");
        MImage image6 = ImageManagerFactory.createImageManager().createNewImage("UserProfiles//Cindy_After_The_War.png");

        image1.setKey(2999999L);
        image2.setKey(5999999L);
        image3.setKey(8999999L);

        image1.setName("Alice's Profile");
        image2.setName("Benny's Profile");
        image3.setName("Cindy's Profile");

        modelStorage.pushModel(image4);
        modelStorage.pushModel(image5);
        modelStorage.pushModel(image6);
    }

    private void pushImages(){

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
