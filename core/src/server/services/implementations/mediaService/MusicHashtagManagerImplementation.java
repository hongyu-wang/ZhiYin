package server.services.implementations.mediaService;

import server.model.media.MHashtag;
import server.services.interfaces.models.MusicHashtagManager;
import tools.utilities.Utils;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public class MusicHashtagManagerImplementation implements MusicHashtagManager {
    @Override
    public long requestAuthenticationKey(String hashtagName) {
        long hashtagKey = 0;
        return hashtagKey;
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
//    }

    @Override
    public void pushHashTag(MHashtag hashtag) {

    }

    @Override
    public MHashtag createNewHashTag(String hashtagName) {
        MHashtag hashtag = new MHashtag();

        hashtag.setMusicKeys(Utils.<Long>newList());
//        long hashtagKey = 0;
//        hashtag.setKey(hashtagKey);
//
//        hashtag.setHashtagName(hashtagName);

        return hashtag;
    }
}
