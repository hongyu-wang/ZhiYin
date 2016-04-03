package client.events.executables.internalChanges.serverInteractions;

import client.pages.friends.FriendProfile;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import server.model.media.MImage;
import server.model.soundCloud.MBand;
import server.model.user.User;
import server.services.factories.ImageManagerFactory;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateProfileArtists extends ExecuteUpdate {
    private FriendProfile friendProfile;
    private String name;

    public ExecuteUpdateProfileArtists(FriendProfile friendProfile, String name) {
        this.friendProfile = friendProfile;
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
            if(!friendProfile.getCurrentArtists().contains(key)){
                MBand artist = localDatabase.getModel(key);

                MImage image = localDatabase.getModel(artist.getBandImage());

                Image artistImage = ImageManagerFactory.createImageManager().mImageToImage(image);

                friendProfile.addFollowing(artistImage);

                friendProfile.getCurrentArtists().add(key);
            }
        }
    }



}
