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


    @Override
    public void pull() {
        User user = modelStorage.getMainUser();

        List<User> newList = new ArrayList<>();

        for(long key: user.getFriendKeys()){
            User friend = modelStorage.<User>getModel(key);
            if(friend == null){
                continue;
            }
            newList.add(friend);
        }
    }

    @Override
    public void push() {
        User user = modelStorage.getMainUser();

        for(User friend: friends){
            if(!user.getFriendKeys().contains(friend.getKey()))
                user.getFriendKeys().add(friend.getKey());
        }
    }

    @Override
    public boolean isUpdated() {
        return true;
    }

    @Override
    public void update(float dt) {
        List<Long> pointers = modelStorage.getMainUser().getFriendKeys();
        for(long friendKey: pointers){
            friends.add(modelStorage.getModel(friendKey));
        }
    }
}
