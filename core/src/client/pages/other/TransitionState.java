package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;


/**
 *
 * Created by Hongyu Wang on 4/6/2016.
 */
public class TransitionState extends State {



    private State newState;
    private State oldState;
    private TransitionType transitionType;
    private boolean willDraw;
    public TransitionState(State newState, TransitionType transitionType){
        this.newState = newState;
        this.transitionType = transitionType;
        init();


    }

    protected void init(){
        super.init();
        this.oldState = StateManager.getInstance().getCurrentState();

        transitionType.setUpAction(newState, oldState);

        willDraw = false;
    }

    @Override
    public void draw() {
        if (willDraw) {
            newState.getStage().draw();
            oldState.getStage().draw();
        }
    }

    @Override
    public void update(float dt) {
        newState.getStage().act(dt);
        oldState.getStage().act(dt);
        willDraw = true;
    }


}
