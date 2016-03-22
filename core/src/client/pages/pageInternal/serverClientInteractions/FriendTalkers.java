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
public class FriendTalkers extends Talkers {

    public List<User> friends;

    public FriendTalkers(){

    }



    /*TODO
    ALL FRIEND TALKERS NEED ACCESS TO ALL FRIENDS


    In a friend talker, there should be two major functionality types.

    FUNCTIONALITY TYPE 1:
        I should be able to iterate through all the friends one by one and do:
            1. Get their name

    FUNCTIONALITY TYPE 2:
        I should be able to select a specific friend:
            1. Send them a message (Be it a text one or an audio one)
            2. Get all messages they sent
                    For each message:
                        Get the type (audio or text)
                        Get the content (audio or text)
            3. Get the profile of the friend.
    */

    /**
     * Pulls all friends into the model Storage.
     *
     */
    @Override
    public void pull() {
        User user = modelStorage.getMainUser();

        for(long key: user.getFriendKeys()){
            modelStorage.requestModelFromServer(User.class.getName(), key);
        }
    }

    /**
     * Pushes all friends which are not added to the current user into
     * the user.
     *
     */
    @Override
    public void push() {
        User user = modelStorage.getMainUser();

        for(User friend: friends){
            if(!user.getFriendKeys().contains(friend))
                user.getFriendKeys().add(friend.getKey());
        }

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
            newFriendList.add(modelStorage.getModel(key));
        }
    }
}
