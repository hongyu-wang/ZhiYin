package client.pages.other;

import client.pages.State;
import client.singletons.StateManager;
import client.tools.Constants;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * This is the primary TransitionType for the enum.
 *
 * This should be passed from every transition.
 *
 * Created by Hongyu Wang on 4/6/2016.
 */
public enum TransitionType implements Constants {
    UP_TO_DOWN(1, true, "Up to down"), DOWN_TO_UP(-1, true, "Down to up"), LEFT_TO_RIGHT(1, false, "Left to right"), RIGHT_TO_LEFT(-1, false, "Right to left"), NONE("None");

    private int dir;
    private boolean type;
    private String name;



    TransitionType(String name){
        this.name = name;
    }

    TransitionType(int dir, boolean type, String name){
        this(name);
        this.dir = dir;
        this.type = type;
    }



    /**
     * Sets up the actions for the stage during the transitions.
     * @param oldStage The stage that you are transitioning from
     * @param newStage The stage that you are transitioning to
     * @param newState The state that you are transitioning to
     */
    public void setUpAction(Stage oldStage, Stage newStage, State newState){
        if (this.name.equals("None")) {
            newStage.addAction(Actions.run(() -> {
                StateManager.getInstance().toTemporaryState(newState);
                oldStage.addAction(Actions.moveTo(0, 0));
            }));
        }

        else if (type) {
            handleHorizontal(oldStage, newStage, newState);
        } else {
            handleVertical(oldStage, newStage, newState);
        }

    }


    private void handleHorizontal(Stage oldStage, Stage newStage, State newState){
        oldStage.addAction(Actions.sequence(
                Actions.moveTo(0, -dir * 1334 * M, 0.5F, Interpolation.pow2Out)
        ));

        newStage.addAction(Actions.sequence(

                        Actions.moveTo(0, dir * 1334, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2Out),
                        Actions.run(() -> {
                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                        })

                )
        );
    }


    private void handleVertical(Stage oldStage, Stage newStage, State newState){
        oldStage.addAction(Actions.sequence(
                Actions.moveTo(-dir*750*M, 0, 0.5F, Interpolation.pow2Out)
        ));



        newStage.addAction(Actions.sequence(

                        Actions.moveTo(dir*750 * M, 0, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2Out),
                        Actions.run(() -> {
                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                        })

                )
        );
    }


    public String toString(){
        return name;
    }




}
