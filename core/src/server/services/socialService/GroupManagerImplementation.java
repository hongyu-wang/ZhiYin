package server.services.socialService;


import server.model.social.Group;

import tools.Utils;

import java.util.List;

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
    public Group createGroup(long user) {
        Group crGroup = new Group();
        crGroup.setCreator(user);
        crGroup.setMembers(Utils.newList());
        crGroup.setAdmins(Utils.newList());
        crGroup.setPosts(Utils.newList());
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
    public Group leaveGroup(long user, Group group) {
        List<Long> uList = group.getMembers();
        uList.remove(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a user to a given group
     *
     * @param user      the user to be added
     * @param group     the group in question
     * @return          the updated group
     */
    @Override
    public Group enterGroup(long user, Group group) {
        List<Long> uList = group.getMembers();
        uList.add(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a post to the given group
     *
     * @param post          post to be added
     * @param group         group in question
     * @return              the updated group
     */
    @Override
    public Group addPost(long post, Group group) {
        List<Long> pList = group.getPosts();
        pList.add(post);
        group.setPosts(pList);
        return group;
    }

    /**
     * Removes the post from the given group
     *
     * @param post          the post that needs to be removed
     * @param group         the group in question
     * @return              the updated group
     */
    @Override
    public Group removePost(long post, Group group) {
        List<Long> pList = group.getPosts();
        pList.remove(post);
        group.setPosts(pList);
        return group;
    }

    /**
     * Retrieves a group from the database
     *
     * @param key           id of the group
     * @return              group with the id
     */
    @Override
    public Group requestGroup(long key){
        //TODO implement this
        return null;
    }
}
