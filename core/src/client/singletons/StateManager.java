package client.singletons;
import client.pageStorage.Pages;
import client.pages.State;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import client.tools.Constants;

/**
 * This is essentially a card layout.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class StateManager implements Disposable, Updatable, Drawable, Constants {



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
        //TODO remove this.
        System.out.println(page);
        currentState = page.getStateReference();
        currentState.reset();
        InputListener.setListener(currentState);
    }


    public void toTemporaryState(State state){
        currentState = state;
        currentState.reset();
        InputListener.setListener(state);
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
