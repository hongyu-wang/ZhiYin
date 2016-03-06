package server.services.socialService;


import server.model.social.Group;
import server.model.social.Post;
import server.model.user.User;
import tools.List;
import tools.Utils;

/**
 * Created by Hairuo on 2016-03-02.
 */
public class GroupManagerImplementation implements GroupManager {

    /**
     * Creates a group with the user as an admin
     *
     * @param user
     * @return the created group
     */
    @Override
    public Group createGroup(User user) {
        Group crGroup = new Group();
        crGroup.setCreator(user);
        crGroup.setMembers(Utils.newList());
        crGroup.setAdmins(new List<User>());
        crGroup.setPosts(new List<Post>());
        return crGroup;
    }

    /**
     * Removes a user from a given group
     *
     * @param user the user to be added
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public Group leaveGroup(User user, Group group) {
        List<User> uList = group.getMembers();
        uList.remove(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a user to a given group
     *
     * @param user the user to be added
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public Group enterGroup(User user, Group group) {
        List<User> uList = group.getMembers();
        uList.add(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a post to the given group
     *
     * @param post post to be added
     * @param group group in question
     * @return the updated group
     */
    @Override
    public Group addPost(Post post, Group group) {
        List<Post> pList = group.getPosts();
        pList.add(post);
        group.setPosts(pList);
        return group;
    }

    /**
     * Removes the post from the given group
     *
     * @param post the post that needs to be removed
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public Group removePost(Post post, Group group) {
        List<Post> pList = group.getPosts();
        pList.remove(post);
        group.setPosts(pList);
        return group;
    }
}
