package client;

import client.pages.State;

import java.util.Hashtable;

/**
 * Created by Hongyu Wang on 3/1/2016.
 */
public class StateManager {
    public static final String PROFILE_STATE = "HomePage";
    public static final String HOME_PAGE_STATE = "NewsFeed";
    public static final String NEWS_FEED = "ProfileManager";

    private static String [] states = {PROFILE_STATE, HOME_PAGE_STATE, NEWS_FEED};

    private Hashtable<String, State> state_control;

    private State current_state;


    public StateManager(String initial_state){
        changeState(initial_state);
        init();
    }


    protected void init(){
        initTable();
    }


    private void initTable(){
        state_control = new Hashtable<String, State>();
        for (String state : states) {
            try {
                state_control.put(state, getStateFromName(state));
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }

        }


    }

    private State getStateFromName(String name) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        return (State)Class.forName(name).newInstance();
    }


    public void changeState(String new_state){
        current_state.pause();
        current_state = state_control.get(new_state);
        current_state.resume();
    }


}
