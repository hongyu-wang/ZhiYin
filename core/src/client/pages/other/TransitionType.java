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
    UP_TO_DOWN(1, true, "Up to down"),
    DOWN_TO_UP(-1, true, "Down to up"),
    LEFT_TO_RIGHT(1, false, "Left to right"),
    RIGHT_TO_LEFT(-1, false, "Right to left"),
    NONE("None"),
    FADE_IN("Fade in");

    private int dir;
    private boolean type;
    private String name;
    private State newState;
    private Stage newStage, oldStage;

    TransitionType(String name){
        this.name = name;
    }

    TransitionType(int dir, boolean type, String name){
        this(name);
        this.dir = dir;
        this.type = type;
    }




    public void setUpAction(State newState, State oldState){

        this.newState = newState;

        newStage = newState.getStage();
        oldStage = oldState.getStage();

        if (this.name.equals("None")) {
            handleDone();
        }
        else if (this.name.equals("Fade in")){
            handleFadeIn();
        }
        else if (!type) {
            handleHorizontal();
        } else {
            handleVertical();
        }

    }

    private void handleFadeIn() {
        newStage.addAction(Actions.sequence(
                Actions.run(
                        () -> {oldStage.addAction(Actions.alpha(0));
                        oldStage.act();}
                ),

                Actions.alpha(0),

                Actions.fadeIn(0.5F),

                Actions.run(
                        () -> {

                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.alpha(1));
                        }
                )
        ));

    }

    private void handleDone(){
        newStage.addAction(Actions.run(() -> {

            StateManager.getInstance().toTemporaryState(newState);
        }));

    }

    private void handleVertical(){
        oldStage.addAction(Actions.sequence(
                Actions.moveTo(0, -dir * 1334 * M, 0.5F, Interpolation.pow2Out)
        ));

        newStage.addAction(Actions.sequence(

                        Actions.moveTo(0, dir * 1334, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2Out),
                        Actions.run(() -> {

                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                            oldStage.act();
                        })

                )
        );
    }


    private void handleHorizontal(){
        oldStage.addAction(Actions.sequence(
                Actions.moveTo(dir*750*M, 0, 0.5F, Interpolation.pow2Out)
        ));



        newStage.addAction(Actions.sequence(

                        Actions.moveTo(-dir*750 * M, 0, 0),
                        Actions.moveTo(0, 0, 0.5F, Interpolation.pow2Out),
                        Actions.run(() -> {
                            StateManager.getInstance().toTemporaryState(newState);
                            oldStage.addAction(Actions.moveTo(0, 0));
                            oldStage.act();
                        })

                )
        );
    }


    public String toString(){
        return name;
    }




}
