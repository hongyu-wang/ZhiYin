package server.model.social;

import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.List;

/**
 * Created by Kevin Zheng on 2016-02-19.
 */
public class Group  extends ServerModel {
    /**
     * For now group only contains a list of users and a list of posts that users
     * have put into the group
     */
    private List<User> members;
    private List<Post> posts;
    private User creator;
    private List<User> admins;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getAdmins() {
        return admins;
    }

    public void setAdmins(List<User> admins) {
        this.admins = admins;
    }
}
