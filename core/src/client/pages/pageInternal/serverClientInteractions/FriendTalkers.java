package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.serverClientInteractions.Talkers;
import server.model.social.MMessage;
import server.model.user.User;
import server.model.user.UserConversations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class FriendTalkers extends Talkers {

    private static final int unreadTheirs = 0;

    private static final int readTheirs = 1;

    private static final int unreadYours = 2;

    private static final int readYours = 3;

    public List<User> friends;
    public List<MMessage> conversations;
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
    public void update(float dt) {
        User user = modelStorage.getUser();

        for(long key: user.getFriendKeys())
            modelStorage.requestModelFromServer(User.class.getName(), key);

        for(long key: user.getConversations())
    }

    @Override
    public void pull() {
        User user = modelStorage.getUser();

        List<User> newList = new ArrayList<>();

        for(long key: user.getFriendKeys()){
            User friend = modelStorage.getModel(key);
            if(friend == null){
                continue;
            }
            newList.add(friend);
        }
    }
}
