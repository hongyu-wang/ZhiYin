package client.pageStorage;

import client.pages.State;
import client.pages.friends.Friends1;
import client.pages.friends.Friends2;
import client.pages.friends.Friends3;
import client.pages.friends.Friends4;
import client.pages.home.Home1;
import client.pages.home.Home2;
import client.pages.home.Home3;
import client.pages.home.Home4;
import client.pages.miscellaneous.NowPlaying;
import client.pages.miscellaneous.Profile;
import client.pages.musicDiary.Diary1;
import client.pages.musicDiary.Diary2;
import client.pages.musicDiary.Diary3;

/**
 * This is the enum storing all possible page states across all the pages.
 * When a new State is created, then you should utilize this Enum.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public enum Pages {
    /**
     * Here should be placed state objects as a classname. Note, className needs
     * to include all subpackages within package.
     */

    FRIENDS1(new Friends1()),
    FRIENDS2(new Friends2()),
    FRIENDS3(new Friends3()),
    FRIENDS4(new Friends4()),
    HOME1(new Home1()),
    HOME2(new Home2()),
    HOME3(new Home3()),
    HOME4(new Home4()),
    NOWPLAYING(new NowPlaying()),
    PROFILE(new Profile()),
    DIARY1(new Diary1()),
    DIARY2(new Diary2()),
    DIARY3(new Diary3()),
    ;




    /**
     * This variable stores the given state Reference to the classname.
     */
    private State stateReference;



    Pages(State state){
      this.stateReference = state;

    }





    /**
     * This method returns the given state reference
     * associated with the given Enum. Essentially makes this enum
     * into a HashTable with the Enum name as a key and the value as the state.
     *
     */
    public State getStateReference() {
        return this.stateReference;
    }
}
