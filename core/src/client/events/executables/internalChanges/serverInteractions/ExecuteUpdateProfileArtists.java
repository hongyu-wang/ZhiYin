package client.events.executables.internalChanges.serverInteractions;

import client.stateInterfaces.Profile;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import server.model.media.MImage;
import server.model.soundCloud.MBand;
import server.model.user.User;
import server.services.factories.ImageManagerFactory;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateProfileArtists extends ExecuteUpdate {
    private Profile profile;
    private String name;

    public ExecuteUpdateProfileArtists(Profile profile, String name) {
        this.profile = profile;
        this.name = name;
    }

    @Override
    public void execute() {
        User user = localDatabase.getModel(localDatabase.getUserKeyByName(name));
        updateArtistsFromServer(user);
    }

    private void updateArtistsFromServer(User user){
        java.util.List<Long> bandKeys = user.getBandKeys();

        for(long key: bandKeys){
            if(!profile.getCurrentArtists().contains(key)){
                MBand artist = localDatabase.getModel(key);

                MImage image = localDatabase.getModel(artist.getBandImage());

                Image artistImage = ImageManagerFactory.createImageManager().mImageToImage(image);

                profile.addFollowing(artist, artistImage);

                profile.getCurrentArtists().add(key);
            }
        }
    }
}
