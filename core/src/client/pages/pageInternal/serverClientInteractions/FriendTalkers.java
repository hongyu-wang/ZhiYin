package client.pages.pageInternal.serverClientInteractions;

import client.pages.pageInternal.serverClientInteractions.Talkers;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class FriendTalkers extends Talkers {

    private static final int unreadTheirs = 0;

    private static final int readTheirs = 1;

    private static final int unreadYours = 2;

    private static final int readYours = 3;
    /*TODO
    ALL FRIEND TALKERS NEED ACCESS TO ALL FRIENDS


    In a friend talker, there should be two major functionality types.

    FUNCTIONALITY TYPE 1:
        I should be able to iterate through all the friends one by one and do:
            1. Get their name
            2. Get the message status (The message status is whether or not the message is read, your message is read,
                    etc).
    FUNCTIONALITY TYPE 2:
        I should be able to select a specific friend:
            1. Send them a message (Be it a text one or an audio one)
            2. Get all messages they sent
                    For each message:
                        Get the type (audio or text)
                        Get the content (audio or text)
            3. When you view the friend, you should set the your view state to <readTheirs> and thus
                change the state of them to <readYours>
    */


    @Override
    public void update(float dt) {

    }


}
