package server.model.social;

import server.model.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Zheng on 2016-02-19.
 */
public class Group {
    /**
     * For now group only contains a list of users and a list of posts that users
     * have put into the group
     */
    private List<User> members;
    private List<Post> posts;
    private User creator;
    private List<User> admins;

    /**Creates a group with various other users.
     *
     * @param user the creator of the group
     */
    public Group(User user){
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();

    }


}
