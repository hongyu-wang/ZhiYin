package server.model.media;

import server.model.structureModels.ServerModel;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public class MHashtag extends ServerModel {
    /**
     * The text of the hashtag.
     */
    private String hashtagName;
    /**
     * The keys to all the music which relates to the hashTag.
     */
    private List<Long> musicKeys;



    /**Returns the string representation of the hashtag.
     *
     * @return  The text of the hashtag.
     */
    public String getHashtagName() {
        return hashtagName;
    }

    /**Returns list of keys to the music.
     *
     * @return  The list of long keys.
     */
    public List<Long> getMusicKeys() {
        return musicKeys;
    }

    public void setHashtagName(String hashtag) {
        this.hashtagName = hashtag;
    }

    public void setMusicKeys(List<Long> musicKeys) {
        this.musicKeys = musicKeys;
    }
}
