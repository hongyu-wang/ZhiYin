package server.model.social;

import server.model.structureModels.ServerModel;
import server.model.user.User;

import java.util.List;

/**
 * MGroup model
 * Contains id's of users and posts
 */
public class MGroup extends ServerModel {

    /**
     * list of id's of the group members
     */
    private List<Long> members;

    /**
     * List of id's of posts that the group contains
     */
    private List<Long> posts;

    /**
     * Id of the creator of the group
     */
    private long creator;

    /**
     * List of id's of the admins of the group
     */
    private List<Long> admins;

    public List<Long> getMembers() {
        return members;
    }

    public void setMembers(List<Long> members) {
        this.members = members;
    }

    public List<Long> getPosts() {
        return posts;
    }

    public void setPosts(List<Long> posts) {
        this.posts = posts;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public List<Long> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Long> admins) {
        this.admins = admins;
    }
}
