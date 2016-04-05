package client.events.executables.internalChanges.serverInteractions;

import client.pages.other.ArtistProfile;
import server.model.media.MMusic;
import server.model.soundCloud.MBand;
import tools.AudioTools.AudioCreator;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateArtistSongs extends ExecuteUpdate{
    private ArtistProfile artistProfile;
    private long artist;

    public ExecuteUpdateArtistSongs(ArtistProfile artistProfile, MBand artist) {
        this.artistProfile = artistProfile;
        this.artist = artist.getKey();
    }

    @Override
    public void execute() {
        MBand artist = localDatabase.getModel(this.artist);
        if(os == MAC) {
            List<MMusic> musicList = AudioCreator.artistToMMusic.get(artist.getName());


            for (MMusic music : musicList) {
                if (artistProfile.getMusicKeys().contains(music.getKey())) {
                    continue;
                }

                artistProfile.addSong(music);
                artistProfile.getMusicKeys().add(music.getKey());
            }
        }
        else {
            for (long key : artist.getSongs()) {
                MMusic music = localDatabase.getModel(key);

                if (artistProfile.getMusicKeys().contains(music.getKey())) {
                    continue;
                }

                artistProfile.addSong(music);
                artistProfile.getMusicKeys().add(music.getKey());
            }
        }
    }
}
