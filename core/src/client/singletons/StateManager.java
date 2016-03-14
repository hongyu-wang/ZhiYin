package client.singletons;
import client.events.ActionEvent;
import client.pageStorage.Pages;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;
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
    private static StateManager ourInstance = new StateManager(Pages.PROFILE);

    /**
     * This returns the current instance of the StateManager class
     * @return the singleton instance of the StateManager
     */
    public static StateManager getInstance() {
        return ourInstance;
    }

    public static final double M = .5;


    /**
     * This is the current state within the statemanager.
     */
    private State currentState;


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
        currentState = page.getStateReference();
    }


    @Override
    public void update(float dt) {
        currentState.update(dt);
    }

    @Override
    public void draw() {
        currentState.draw();
    }

    @Override
    public void dispose() {
        currentState.dispose();
    }

    /**
     * This is the method that is called when
     * InputListener registers an input on the screen.
     */
    public void receiveInput(){
        currentState.checkPressed();
    }

}
