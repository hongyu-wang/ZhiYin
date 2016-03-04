package server.model.user;

import server.model.musicSharing.MusicPost;
import tools.ServiceList;

/**A model of all user uploaded content.
 *
 *      - Post
 *      - Music
 *      - Annotation
 *      - Comment
 *
 * Created by Kevin Zheng on 2016-03-02.
 */
public class UserUploadedContent {
    ServiceList<String> postKeys;
    ServiceList<MusicPost> posts;

    /**Returns the service list of posts the user has uploaded.
     *
     * @return  The list of MusicPosts.
     */
    public ServiceList<MusicPost> getPosts() {
        return posts;
    }

    /**Returns the service list of all keys to posts the user has uploaded.
     *
     * @return  The list of post keys.
     */
    public ServiceList<String> getPostKeys(){
        return postKeys;
    }

    public void setPosts(ServiceList<MusicPost> posts) {
        this.posts = posts;
    }

    public void setPostKeys(ServiceList<String> postKeys){
        this.postKeys = postKeys;
    }
}
