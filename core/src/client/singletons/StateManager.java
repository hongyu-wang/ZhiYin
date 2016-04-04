package client.singletons;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Updatable;
import client.tools.Constants;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

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
        currentState = page.getStateReference();
        currentState.reset();
        InputListener.setListener(currentState);
    }


    public void toTemporaryState(State state){
        currentState = state;
        killActions();
        currentState.reset();

    }

    private void killActions(){
        InputListener.prepare();
        Action action = Actions.sequence(
                Actions.alpha(0),

                Actions.fadeIn(0.5F),

                Actions.run(
                        () -> InputListener.setListener(currentState)
                )
        );
        currentState.getStage().addAction(action);
    }



    @Override
    public void update(float dt) {

        currentState.update(dt);

        TalkerFactory.getServerTalker().update(dt);
    }

    @Override
    public void draw() {
        currentState.draw();
        //translateStage(1);
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
        currentState.getInputController().checkPressed();

    }


    public void receiveDragged(){
        currentState.getInputController().checkDragged();
    }

    public void receiveRelease(){
        currentState.getInputController().checkRelease();
    }

    public void translateStage(int dir) {
        currentState.getStage().getCamera().translate(dir*1F, 0, 0);
    }
}
