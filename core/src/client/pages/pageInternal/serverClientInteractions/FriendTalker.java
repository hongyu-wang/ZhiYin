package client.pages.pageInternal.serverClientInteractions;

import server.model.user.User;
import tools.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class FriendTalker extends Talkers {

    //--Interface Fields
    private List<User> friends;

    //Getters and Setters
    public List<User> getAllFriends(){
        return friends;
    }


    /*------------------------------------------------------------------------*/

    @Override
    public void init() {
        friends = Utils.newList();
    }

    /*------------------------------------------------------------------------*/

    /**
     * Pulls all friends into the model Storage.
     *
     */
    @Override
    public void pull() {
        modelStorage.requestModelFromServer(getMainUser().getKey());

        for(long key: super.getMainUser().getFriendKeys()){
            modelStorage.requestModelFromServer(key);
        }
    }

    /**
     * Pushes user friends to the server.
     *
     * Pushes the user model.
     *
     */
    @Override
    public void push() {

        //Set
        for(User friend: friends){
            if(!super.getMainUser().getFriendKeys().contains(friend.getKey()))
                super.getMainUser().getFriendKeys().add(friend.getKey());
        }

        //Push
        modelStorage.pushModel(super.getMainUser());
    }

    /**Checks if all of the friends have been successfully pulled.
     *
     * @return  True if all friends exist within this talker.
     */
    @Override
    public boolean isUpdated() {
        for(User user: friends){
            if(user == null){
                return false;
            }
        }
        return true;
    }

    /**
     * Updates the friends List from modelStorage.
     *
     * @param dt The rate of change of updating
     */
    @Override
    public void update(float dt) {
        List<User> newFriendList = new ArrayList<>();
        System.out.println(modelStorage.getMainUser());
        for(long key: modelStorage.getMainUser().getFriendKeys()){
            newFriendList.add(modelStorage.<User>getModel(key));
        }

        this.friends = newFriendList;
    }
}
