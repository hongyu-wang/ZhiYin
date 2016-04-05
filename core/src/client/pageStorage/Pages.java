package client.pageStorage;

import client.pages.State;
import client.pages.other.Login;
import client.singletons.StateManager;
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
    FRIENDS4("friends.Friends4"),
    HOME("home.Home"),
    ARTIST("home.Artist"),
    DISCOVERY("home.Discovery"),
    TOPSINGLES("home.TopSingles"),
    MYPROFILE("other.MyProfile"),
    LOGIN("other.Login"),
    DIARY1("musicDiary.Diary1"),
    DIARY2("musicDiary.Diary2");


    /**
     * This variable stores the given state Reference to the classname.
     */
    private State stateReference;

    private String name;

    Pages(String state){
      name = state;
    }

    public static void initLogin(){
        Pages page = LOGIN;
        try {
            page.stateReference = (State) ClassReflection.forName("client.pages." + page.name).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ReflectionException e) {
            e.printStackTrace();
        }
    }

    public static void initClass(){

        for (Pages page : Pages.values()){

            if (page != null && page != Pages.LOGIN ) {
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

    public String toString(){
        return name;
    }

}
