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
    public UserUploadedContent requestAllContent(long userKey) {
        UserUploadedContent userContent = new UserUploadedContent();

        List<Long> keys = null; //Server request
        userContent.setPostKeys(keys);

        List<MusicPost> musicPosts = new ServiceList<MusicPost>();
        for(long key: userContent.getPostKeys()){
            MusicPost post = new PostManagerImplementation().requestPost(key);
            musicPosts.add(post);
        }
        userContent.setPosts(musicPosts);

        //TODO request from server.
        return userContent;
    }

    @Override
    public User addContentEntry(User user, MusicPost musicPost) {
        user.getContent().getPostKeys().add(musicPost.getKey());
        user.getContent().getPosts().add(musicPost);
        return user;
        //TODO request change to server.
    }
}
