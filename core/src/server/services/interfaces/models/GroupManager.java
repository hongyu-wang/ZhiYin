
package server.services.interfaces.models;


import server.model.social.MGroup;

/**
 * Created by Kevin Zheng on 2016-03-02.
 */
public interface GroupManager {


    /**
     * Creates a group with the user as an admin
     *
     * @param user the creator the of group
     * @return the created group
     */
    public MGroup createGroup(long user);

    /**
     * Removes a user from a given group
     *
     * @param user  the user to be added
     * @param group the group in question
     * @return the updated group
     */
    public MGroup leaveGroup(long user, MGroup group);

    /**
     * Adds a user to a given group
     *
     * @param user  the user to be added
     * @param group the group in question
     * @return the updated group
     */
    public MGroup enterGroup(long user, MGroup group);

    /**
     * Adds a post to the given group
     *
     * @param post  post to be added
     * @param group group in question
     * @return the updated group
     */
    public MGroup addPost(long post, MGroup group);

    /**
     * Removes the post from the given group
     *
     * @param post  the post that needs to be removed
     * @param group the group in question
     * @return the updated group
     */
    public MGroup removePost(long post, MGroup group);

}
