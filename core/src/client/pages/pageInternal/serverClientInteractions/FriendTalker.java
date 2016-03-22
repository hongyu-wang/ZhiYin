package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.serverClientInteractions.Talkers;
import server.model.social.MConversation;
import server.model.social.MMessage;
import server.model.user.User;
import server.model.user.UserConversations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class FriendTalker extends Talkers {

    //--Interface Fields
    public List<User> friends;

    /*------------------------------------------------------------------------*/

    @Override
    public void init() {

    }

    /*------------------------------------------------------------------------*/

    /**
     * Pulls all friends into the model Storage.
     *
     */
    @Override
    public void pull() {

        for(long key: user.getFriendKeys()){
            modelStorage.requestModelFromServer(User.class.getName(), key);
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
            if(!user.getFriendKeys().contains(friend.getKey()))
                user.getFriendKeys().add(friend.getKey());
        }

        //Push
        modelStorage.pushModel(user);
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
        for(long key: modelStorage.getMainUser().getFriendKeys()){
            newFriendList.add(modelStorage.<User>getModel(key));
        }

        this.friends = newFriendList;
    }
}
