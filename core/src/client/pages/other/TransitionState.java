package client.pages.other;

import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 *
 * Created by Hongyu Wang on 3/28/2016.
 */
public class TransitionState extends State {
    private static final float TOTAL_DELAY = 2;
    private float delay;
    private State state;


    public TransitionState(State state){
        init();
        this.state = state;
    }

    @Override
    protected void init(){
        super.init();
        delay = -10;
    }


    @Override
    public void update(float dt) {
        super.update(dt);

        delay ++;
        float delay2 = Math.abs(delay);
        if (delay > TOTAL_DELAY) delay = TOTAL_DELAY;

        Gdx.gl.glClearColor(delay2*0.01F/TOTAL_DELAY, delay2*0.01F/TOTAL_DELAY, delay2*0.01F/TOTAL_DELAY, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (delay == TOTAL_DELAY){
            Gdx.gl.glClearColor(0, 0, 0, 1);
            StateManager.getInstance().toTemporaryState(state);
        }
    }



    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
