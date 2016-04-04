package client.events.executables.internalChanges.serverInteractions;

import client.pageStorage.Pages;
import client.pages.other.ArtistProfile;
import client.pages.other.MyProfile;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import server.model.media.MImage;
import server.model.soundCloud.MBand;
import server.services.factories.ImageManagerFactory;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteFollowArtist implements ExecuteServer {

    private ArtistProfile artistProfile;
    private long artist;

    public ExecuteFollowArtist(ArtistProfile artistProfile, MBand artist){
        this.artistProfile = artistProfile;
        this.artist = artist.getKey();
    }

    @Override
    public void execute() {
        MBand artist = localDatabase.getModel(this.artist);
        MImage mImage = localDatabase.getModel(artist.getBandImage());
        Image image = ImageManagerFactory.createImageManager().mImageToImage(mImage);

        ((MyProfile)Pages.MYPROFILE.getStateReference()).addFollowing(artist, image);
    }
}
