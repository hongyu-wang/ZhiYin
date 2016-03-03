package tools.manager;

import model.tools.social.Group;
import model.tools.social.Post;
import model.user.User;

/**
 * Created by Hairuo on 2016-03-02.
 */
public class GroupManagerImplementation implements GroupManager{

    /**
     * Creates a group with the user as an admin
     *
     * @param user
     * @return the created group
     */
    @Override
    public Group createGroup(User user) {
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
    }
}
