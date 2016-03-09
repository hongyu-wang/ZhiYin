
package server.services.socialService;


import server.model.social.Group;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface GroupManager {


    /**
     * Creates a group with the user as an admin
     *
     * @param user          the creator the of group
     * @return              the created group
     */
    public Group createGroup(long user);

    /**
     * Removes a user from a given group
     *
     * @param user          the user to be added
     * @param group         the group in question
     * @return              the updated group
     */
    public Group leaveGroup(long user, Group group);

    /**
     * Adds a user to a given group
     *
     * @param user          the user to be added
     * @param group         the group in question
     * @return              the updated group
     */
    public Group enterGroup(long user, Group group);

    /**
     * Adds a post to the given group
     *
     * @param post          post to be added
     * @param group         group in question
     * @return              the updated group
     */
    public Group addPost(long post, Group group);

    /**
     * Removes the post from the given group
     *
     * @param post          the post that needs to be removed
     * @param group         the group in question
     * @return              the updated group
     */
    public Group removePost(long post, Group group);

    /**
     * Retrieves a group from the database
     *
     * @param key           id of the group
     * @return              group with the id
     */
    public Group getGroup(long key);

}