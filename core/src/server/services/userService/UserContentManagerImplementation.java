package server.services.userService;

import server.model.social.MusicPost;
import server.model.social.Post;
import server.model.user.User;
import server.model.user.UserUploadedContent;
import tools.ServiceList;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class UserContentManagerImplementation implements UserContentManager {
    @Override
    public UserUploadedContent requestAllContent(long contentKey) {
        UserUploadedContent userContent = new UserUploadedContent();
        userContent.setKey(contentKey);

        List<Long> keys = null; //Server request
        userContent.setPostKeys(keys);

        return userContent;
        //TODO request from server.
    }

    @Override
    public UserUploadedContent addContentEntry(UserUploadedContent content, MusicPost musicPost) {
        content.getPostKeys().add(musicPost.getKey());
        return content;
        //TODO request change to server.
    }
}
