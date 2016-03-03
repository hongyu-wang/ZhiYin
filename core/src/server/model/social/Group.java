package server.model.social;

import server.model.user.User;
import Service;

/**
 * Created by Kevin Zheng on 2016-02-19.
 */
public class Group {
    /**
     * For now group only contains a list of users and a list of posts that users
     * have put into the group
     */
    private Service<User> members;
    private Service<Post> posts;
    private User creator;
    private Service<User> admins;

    public Service<User> getMembers() {
        return members;
    }

    public void setMembers(Service<User> members) {
        this.members = members;
    }

    public Service<Post> getPosts() {
        return posts;
    }

    public void setPosts(Service<Post> posts) {
        this.posts = posts;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Service<User> getAdmins() {
        return admins;
    }

    public void setAdmins(Service<User> admins) {
        this.admins = admins;
    }
}
