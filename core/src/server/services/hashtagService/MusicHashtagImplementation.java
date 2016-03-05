package server.services.hashtagService;

import server.model.media.Hashtag;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public class MusicHashtagImplementation implements MusicHashtag {
    @Override
    public boolean validateHashtag(String hashtagName) {
        //TODO Request from server.
        return false;
    }

    @Override
    public Hashtag requestHashTag(String hashtagName) {
        Hashtag hashtag = new Hashtag();
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
        hashtag.setHashtag(hashtagName);
        return hashtag;
    }
}
