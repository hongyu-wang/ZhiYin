package server.services.implementations.socialService;


import server.model.social.MGroup;

import server.services.interfaces.models.GroupManager;
import tools.utilities.Utils;

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
    public MGroup createGroup(long user) {
        MGroup crGroup = new MGroup();
        crGroup.setCreator(user);
        crGroup.setMembers(Utils.<Long>newList());
        crGroup.setAdmins(Utils.<Long>newList());
        crGroup.setPosts(Utils.<Long>newList());
        return crGroup;
    }

    /**
     * Removes a user from a given group
     *
     * @param user  the user to be added
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public MGroup leaveGroup(long user, MGroup group) {
        List<Long> uList = group.getMembers();
        uList.remove(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a user to a given group
     *
     * @param user  the user to be added
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public MGroup enterGroup(long user, MGroup group) {
        List<Long> uList = group.getMembers();
        uList.add(user);
        group.setMembers(uList);
        return group;
    }

    /**
     * Adds a post to the given group
     *
     * @param post  post to be added
     * @param group group in question
     * @return the updated group
     */
    @Override
    public MGroup addPost(long post, MGroup group) {
        List<Long> pList = group.getPosts();
        pList.add(post);
        group.setPosts(pList);
        return group;
    }

    /**
     * Removes the post from the given group
     *
     * @param post  the post that needs to be removed
     * @param group the group in question
     * @return the updated group
     */
    @Override
    public MGroup removePost(long post, MGroup group) {
        List<Long> pList = group.getPosts();
        pList.remove(post);
        group.setPosts(pList);
        return group;
    }

//    /**
//     * Retrieves a group from the database
//     *
//     * @param key id of the group
//     * @return group with the id
//     */
//    @Override
//    public MGroup getGroup(long key) {
//        return null;
//    }
}
