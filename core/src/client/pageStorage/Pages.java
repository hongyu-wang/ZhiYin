package client.pageStorage;

import client.pages.State;
import client.pages.friends.Friends1;
import client.pages.friends.Friends2;
import client.pages.friends.Friends3;
import client.pages.friends.Friends4;
import client.pages.home.Home1;
import client.pages.home.Home3;
import client.pages.home.Home4;
import client.pages.other.NowPlaying;
import client.pages.other.Profile;
import client.pages.musicDiary.Diary1;
import client.pages.musicDiary.Diary2;
import client.pages.musicDiary.Diary3;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.lang.reflect.InvocationTargetException;

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

    FRIENDS1("friends.Friends1"),
    FRIENDS2("friends.Friends2"),
    FRIENDS3("friends.Friends3"),
    FRIENDS4("friends.Friends4"),
    HOME1("home.Home1"),
    HOME3("home.Home3"),
    HOME4("home.Home4"),
    NOWPLAYING("other.NowPlaying"),
    NOWPLAYING2("other.NowPlaying2"),
    PROFILE("other.Profile"),
    DIARY1("musicDiary.Diary1"),
    DIARY2("musicDiary.Diary2"),
    DIARY3("musicDiary.Diary3"),
    DIARY4("musicDiary.Diary4");





    /**
     * This variable stores the given state Reference to the classname.
     */
    private State stateReference;

    private String name;

    Pages(String state){
      name = state;
    }


    public static void initClass(){

        for (Pages page : Pages.values()){
            if (page != null) {
                try {
                    page.stateReference = (State) ClassReflection.forName("client.pages." + page.name).getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ReflectionException e) {
                    e.printStackTrace();
                }
            }
        }
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
