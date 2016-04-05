package client.pages.pageInternal.serverClientInteractions;

import server.model.media.MImage;
import server.model.user.User;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.util.Map;

/**
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class ProfileTalker extends Talkers{
    private static Map<Long, Profile> userProfiles = Utils.newMap();

    private Profile currentProfile;

    //--Interface Fields

    //Getters and Setters
    public byte[] getProfileImage() {
        return currentProfile.getProfileImage();
    }

    public String getName() {
        return currentProfile.getName();
    }

    public String getDescription() {
        return currentProfile.getDescription();
    }


    /*------------------------------------------------------------------------*/

    @Override
    @Deprecated
    public void init() {
    }


    public void init(User user){
        if(userProfiles.keySet().contains(user.getKey())){
            currentProfile = userProfiles.get(user.getKey());
        }
        else{
            currentProfile = new Profile();
            currentProfile.init(user);

            userProfiles.put(user.getKey(), currentProfile);
        }
    }

    /*------------------------------------------------------------------------*/



    @Override
    public void pull() {
        currentProfile.pull();
    }

    @Override
    public void push() {
        currentProfile.push();
    }

    @Override
    public boolean isUpdated() {
        return currentProfile.isUpdated();
    }

    @Override
    public boolean isWaiting(){
        return currentProfile.isWaiting();
    }

    @Override
    public void update(float dt) {
        currentProfile.update(dt);
    }



    //-- PRIVATE PROFILE CLASS

    /**PRIVATE PROFILE CLASS:
     *
     *      Stores the user information based on a main model: user .
     *
     */
    private class Profile extends Talkers{

        private User user;
        private UserProfile profile;

        //--Interface Fields
        private byte[] profileImage;
        private String name;
        private String description;

        //Getters and Setters
        public byte[] getProfileImage() {
            return profileImage;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }


        /*------------------------------------------------------------------------*/

        @Override
        @Deprecated
        public void init() {
        }


        public void init(User user){
            this.user = user;
        }

        /*------------------------------------------------------------------------*/



        @Override
        public void pull() {
            super.setWaiting(true);

            profile = localDatabase.getModel(user.getProfileKey());

            localDatabase.requestModelFromServer(
                    profile.getImageKey());
        }

        @Override
        public void push() {
//            profile = localDatabase.getModel(user.getProfile());
//
//            MImage image = localDatabase.getModel(profile.getImageKey());
//
//            //Set
//            profile.setUsername(name);
//            profile.setDescription(description);
//            image.setImage(this.profileImage);
//
//            //Push
//            localDatabase.pushModel(profile);
//            localDatabase.pushModel(image);
        }

        @Override
        public boolean isUpdated() {
            boolean updated = super.checkOriginalUpdate();

            if(this.name == null){
                return false;
            }

            if(this.description == null){
                return false;
            }

            if(this.profileImage == null){
                return false;
            }

            super.setWaiting(!updated);

            return updated;
        }


        @Override
        public void update(float dt) {
            profile = localDatabase.getModel(user.getProfileKey());

            MImage image = localDatabase.getModel(profile.getImageKey());

            if(image == null){
                localDatabase.requestModelFromServer(profile.getImageKey());
                return;
            }

            name = profile.getUsername();
            description = profile.getDescription();
            profileImage = image.getImage();
        }
    }
}
