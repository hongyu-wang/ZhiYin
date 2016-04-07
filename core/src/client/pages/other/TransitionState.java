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



    private Stage newStage;
    private Stage oldStage;
    private boolean willDraw;
    public TransitionState(State newState, TransitionType ty){
        init();

        newStage = newState.getStage();



        oldStage = StateManager.getInstance().getCurrentState().getStage();

        ty.setUpAction(oldStage, newStage, newState);

        willDraw = false;


    }


    @Override
    public void draw() {
        if (willDraw) {
            oldStage.draw();
            newStage.draw();
        }
    }

    @Override
    public void update(float dt) {
        oldStage.act(dt);
        newStage.act(dt);
        willDraw = true;
    }


}
