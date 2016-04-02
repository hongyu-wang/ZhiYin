package server.services.implementations.userService;

import server.model.soundCloud.MMusicPost;
import server.model.user.UserUploadedContent;
import server.services.interfaces.models.UserContentManager;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserContentManagerImplementation implements UserContentManager {
//    @Override
//    public UserUploadedContent requestAllContent(long contentKey) {
//        UserUploadedContent userContent = new UserUploadedContent();
//        userContent.setKey(contentKey);
//
//        List<Long> keys = null; //Server request
//        userContent.setPostKeys(keys);
//
//        return userContent;
//
//    }

    @Override
    public UserUploadedContent addContentEntry(UserUploadedContent content, MMusicPost musicPost) {
        content.getPostKeys().add(musicPost.getKey());
        return content;
        //TODO request change to server.
    }
}
