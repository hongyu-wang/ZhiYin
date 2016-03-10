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
    private List<Long> members;
    private List<Long> posts;
    private long creator;
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
