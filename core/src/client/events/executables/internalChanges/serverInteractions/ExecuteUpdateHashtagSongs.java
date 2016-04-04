package client.events.executables.internalChanges.serverInteractions;

import client.pages.home.Tagged;
import server.model.media.MHashtag;
import server.model.media.MMusic;

/**
 * Created by Kevin Zheng on 2016-04-03.
 */
public class ExecuteUpdateHashtagSongs extends ExecuteUpdate {
    private Tagged tagPage;
    private String hashtag;

    public ExecuteUpdateHashtagSongs(Tagged tagPage, String hashtag) {
        this.tagPage = tagPage;
        this.hashtag = hashtag;
    }

    @Override
    public void execute() {
        MHashtag hashtag = localDatabase.getModel(localDatabase.getHashtagByName(this.hashtag));

        for(long key: hashtag.getMusicKeys()){
            MMusic music = localDatabase.getModel(key);
            tagPage.addSong(music);
        }
    }
}
