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
    public TransitionState(State newState, int dir){
        init();

        newStage = newState.getStage();



        oldStage = StateManager.getInstance().getCurrentState().getStage();
        oldStage.act();

        oldStage.addAction(Actions.sequence(
                Actions.moveTo(-dir*750*M, 0, 0.5F, Interpolation.pow2In)
        ));



        newStage.addAction(Actions.sequence(

                        Actions.moveTo(dir*750 * M, 0, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2In),
                        Actions.run(() -> {
                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                        })

                )
        );

        willDraw = false;


    }

    public TransitionState(State newState, int dir, boolean verbose){
        init();

        newStage = newState.getStage();



        oldStage = StateManager.getInstance().getCurrentState().getStage();
        oldStage.act();

        oldStage.addAction(Actions.sequence(
                Actions.moveTo(0, -dir * 1334*M, 0.5F, Interpolation.pow2In)
        ));



        newStage.addAction(Actions.sequence(

                        Actions.moveTo(0, dir*1334, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2In),
                        Actions.run(() -> {
                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                        })

                )
        );

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

    @Override
    public void dispose() {

    }
}
