package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.modelStorage.ModelStorage;
import com.badlogic.gdx.graphics.Texture;
import server.model.media.MImage;
import server.model.user.User;
import server.model.user.UserProfile;
import server.model.user.UserUploadedContent;

/**
 * Fuck you Kevin Zheng
 *
 * Created by Hongyu Wang on 3/20/2016.
 */
public class ProfileTalker extends Talkers{
    public Texture profileImage;
    public String name;
    public String description;

    private User user;

    public ProfileTalker(User user){
        this.user = user;
        pull();
    }

    @Override
    public void pull() {
        UserProfile profile = modelStorage.getModel(user.getProfile());

        modelStorage.requestModelFromServer(
                UserUploadedContent.class.getName()
                , profile.getImageKey());
    }

    @Override
    public void push() {
        UserProfile profile = modelStorage.getModel(user.getProfile());

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
        return super.checkUpdated();
    }


    @Override
    public void update(float dt) {
        UserProfile profile = modelStorage.getModel(user.getProfile());

        MImage image = modelStorage.getModel(profile.getImageKey());

        name = profile.getUsername();
        description = profile.getDescription();
        profileImage = image.getImage();
    }
}
