package server.services.mediaService;

import server.model.media.MHashtag;
import server.services.serviceInterfaces.MusicHashtagManager;

import java.util.List;

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

//    @Override
//    public MHashtag requestHashTag(long hashtagKey) {
//        MHashtag hashtag = new MHashtag();
//        hashtag.setKey(hashtagKey);
//
//        List<Long> keys = null;
//        hashtag.setMusicKeys(keys);
//
//        return hashtag;
//        //TODO Request from server.
//    }

    @Override
    public void pushHashTag(MHashtag hashtag) {
        //TODO Push to server.
    }

    @Override
    public MHashtag createNewHashTag(String hashtagName) {
        MHashtag hashtag = new MHashtag();

        long hashtagKey = 0;
        hashtag.setKey(hashtagKey);
        //TODO Generate key.

        hashtag.setHashtag(hashtagName);

        return hashtag;
    }
}
