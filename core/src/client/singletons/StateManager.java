package client.singletons;
import client.events.ActionEvent;
import client.pageStorage.Pages;
import client.pages.State;
import client.stateInterfaces.*;
import com.badlogic.gdx.math.Matrix4;
import driver.GameLoop;

/**
 * This is essentially a card layout.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class StateManager implements Disposable, Updatable, Drawable {
    /**
     * The current instance of StateManager
     */
    private static StateManager ourInstance = new StateManager();

    /**
     * This returns the current instance of the StateManager class
     * @return the singleton instance of the StateManager
     */
    public static StateManager getInstance() {
        return ourInstance;
    }

    public static final float M = 0.5F;


    /**
     * This is the current state within the statemanager.
     */
    private State currentState;


    private StateManager(){
        init();

    }


    protected void init(){

    }


    /**
     * This is the changeState method inside the StateManager.
     * @param page the page within the Pages enum
     */
    public void changeState(Pages page){
        currentState = page.getStateReference();
        InputListener.setListener(page);
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
        currentState.getInputController(State.SHELLINPUT).checkPressed();

    }


    public void recieveDragged(){
        currentState.getInputController(State.SHELLINPUT).checkDragged();
    }

    public void recieveRelease(){
        currentState.getInputController(State.SHELLINPUT).checkRelease();
    }

}
