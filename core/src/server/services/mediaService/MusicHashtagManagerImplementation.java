package server.services.mediaService;

import server.model.media.Hashtag;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public class MusicHashtagManagerImplementation implements MusicHashtagManager {
    @Override
    public long requestAuthenticationKey(String hashtagName) {
        long hashtagKey = 0;
        return hashtagKey;
        //TODO Request from server.
    }

    @Override
    public Hashtag requestHashTag(long hashtagKey) {
        Hashtag hashtag = new Hashtag();
        hashtag.setKey(hashtagKey);

        hashtag.

        return hashtag;
        //TODO Request from server.
    }

    @Override
    public void pushHashTag(Hashtag hashtag) {
        //TODO Push to server.
    }

    @Override
    public Hashtag createNewHashTag(String hashtagName) {
        Hashtag hashtag = new Hashtag();

        long hashtagKey = 0;
        hashtag.setKey(hashtagKey);
        //TODO Generate key.

        hashtag.setHashtag(hashtagName);

        return hashtag;
    }
}
