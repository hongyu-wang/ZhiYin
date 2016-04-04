package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.ArtistProfile;
import server.model.soundCloud.MBand;
import server.model.structureModels.ServerModel;
import server.model.user.User;
import tools.utilities.Utils;

import java.util.List;

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
        User mainUser = localDatabase.getMainUser();
        if(mainUser.getBandKeys().contains(artist)){
            return;
        }
        mainUser.getBandKeys().add(artist);

        List<ServerModel> pushList = Utils.newList();

        pushList.add(mainUser);

        localDatabase.pushModel(pushList);
    }
}
