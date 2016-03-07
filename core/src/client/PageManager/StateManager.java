package client.PageManager;

import client.MainBatch;
import client.pages.State;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Hashtable;

/**
 * This is the current StateManager class.
 * This class shows the current state and allows you to also change
 * the state.
 *
 * Created by Hongyu Wang on 3/1/2016.
 */
public class StateManager {
    private State current_state;


    public StateManager(Pages initial_state){
        init();
        changeState(initial_state);
    }


    protected void init(){

    }


    public void draw(){
        current_state.draw();
    }

    public void update(float dt){
        current_state.update(dt);
    }


    public void changeState(Pages page){
        current_state.pause();
        current_state = page.getStateReference();
        current_state.resume();
    }


}
