package client.singletons;

import client.PageManager.Pages;
import client.pages.State;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;

/**
 * This is essentially a card layout.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class StateManager implements Disposable, Updatable, Drawable {
    /**
     * The current instance of StateManager
     */
    private static StateManager ourInstance = new StateManager(Pages.MAIN);

    /**
     * This returns the current instance of the StateManager class
     * @return the singleton instance of the StateManager
     */
    public static StateManager getInstance() {
        return ourInstance;
    }




    /**
     * This is the current state within the statemanager.
     */
    private State current_state;


    private StateManager(Pages initial_state){
        init();
        changeState(initial_state);
    }


    protected void init(){

    }


    /**
     * This is the changeState method inside the StateManager.
     * @param page the page within the Pages enum
     */
    public void changeState(Pages page){
        current_state = page.getStateReference();
    }


    @Override
    public void update(float dt) {
        current_state.update(dt);
    }

    @Override
    public void draw() {
        current_state.draw();
    }

    @Override
    public void dispose() {
        current_state.dispose();
    }


}