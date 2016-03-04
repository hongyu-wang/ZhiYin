package server.services.userService;

import server.model.musicSharing.MusicPost;
import server.model.user.User;
import server.model.user.UserUploadedContent;

/**
 * Created by Kevin Zheng on 2016-03-03.
 */
public class ContentManagerImplementation implements ContentManager {
    @Override
    public UserUploadedContent requestAllContent(String user) {
        UserUploadedContent userContent = new UserUploadedContent();
        //TODO request from server.
        return userContent;
    }

    @Override
    public User addContentEntry(User user, MusicPost musicPost) {
//        user.getContent().getPostKeys().add(musicPost.getKey());
        user.getContent().getPosts().add(musicPost);
        return user;
        //TODO Finish KeyObject design.
        //TODO request change to server.
    }
}
