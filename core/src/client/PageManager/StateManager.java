package client.PageManager;

import client.pages.State;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;


/**
 * This is the current StateManager class.
 * This class shows the current state and allows you to also change
 * the state.
 *
 * Created by Hongyu Wang on 3/1/2016.
 */
public class StateManager implements Updatable, Drawable, Disposable {
    private State current_state;


    public StateManager(Pages initial_state){
        init();
        changeState(initial_state);
    }


    protected void init(){

    }



    public void changeState(Pages page){
        current_state.pause();
        current_state = page.getStateReference();
        current_state.resume();
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
