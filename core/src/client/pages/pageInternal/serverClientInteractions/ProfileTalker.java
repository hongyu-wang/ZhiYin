package client.pages.pageInternal.serverClientInteractions;

import com.badlogic.gdx.graphics.Texture;
import server.model.media.MImage;
import server.model.user.User;
import server.model.user.UserProfile;

/**
 * Fuck you Kevin Zheng
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class ProfileTalker extends Talkers{
    private UserProfile profile;

    //--Interface Fields
    private Texture profileImage;
    private String name;
    private String description;

    //Getters and Setters
    public Texture getProfileImage() {
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
        pull();
    }

    /*------------------------------------------------------------------------*/



    @Override
    public void pull() {
        profile = modelStorage.getModel(user.getProfile());

        modelStorage.requestModelFromServer(
                MImage.class.getName()
                , profile.getImageKey());
    }

    @Override
    public void push() {
        profile = modelStorage.getModel(user.getProfile());

        MImage image = modelStorage.getModel(profile.getImageKey());

        //Set
        profile.setUsername(name);
        profile.setDescription(description);
        image.setImage(this.profileImage);

        //Push
        modelStorage.pushModel(profile);
        modelStorage.pushModel(image);
    }

    @Override
    public boolean isUpdated() {
        return super.checkOriginalUpdate();
    }


    @Override
    public void update(float dt) {
        profile = modelStorage.getModel(user.getProfile());

        MImage image = modelStorage.getModel(profile.getImageKey());

        name = profile.getUsername();
        description = profile.getDescription();
        profileImage = image.getImage();
    }
}
