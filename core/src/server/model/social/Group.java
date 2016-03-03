package server.model.social;

import server.model.user.User;
import tools.ServiceList;

/**
 * Created by Kevin Zheng on 2016-02-19.
 */
public class Group {
    /**
     * For now group only contains a list of users and a list of posts that users
     * have put into the group
     */
    private ServiceList<User> members;
    private ServiceList<Post> posts;
    private User creator;
    private ServiceList<User> admins;

    public ServiceList<User> getMembers() {
        return members;
    }

    public void setMembers(ServiceList<User> members) {
        this.members = members;
    }

    public ServiceList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ServiceList<Post> posts) {
        this.posts = posts;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ServiceList<User> getAdmins() {
        return admins;
    }

    public void setAdmins(ServiceList<User> admins) {
        this.admins = admins;
    }
}
