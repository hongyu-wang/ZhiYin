package server.model.user;

import server.model.musicSharing.MusicPost;

import java.util.List;

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
    List<String> postKeys;
    List<MusicPost> posts;

    /**Returns the service list of posts the user has uploaded.
     *
     * @return  The list of MusicPosts.
     */
    public List<MusicPost> getPosts() {
        return posts;
    }

    /**Returns the service list of all keys to posts the user has uploaded.
     *
     * @return  The list of post keys.
     */
    public List<String> getPostKeys(){
        return postKeys;
    }

    public void setPosts(List<MusicPost> posts) {
        this.posts = posts;
    }

    public void setPostKeys(List<String> postKeys){
        this.postKeys = postKeys;
    }
}
