package client.singletons;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.stateInterfaces.Disposable;
import client.stateInterfaces.Drawable;
import client.stateInterfaces.Gesturable;
import client.stateInterfaces.Updatable;
import client.tools.Constants;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import tools.AudioTools.AudioPlayer;

/**
 * This is essentially a card layout.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public class StateManager implements Disposable, Updatable, Drawable, Constants {
    private boolean stateUp;

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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * This is the current state within the statemanager.
     */
    private State currentState;


    private StateManager(){
        init();
    }


    protected void init(){
        stateUp = false;
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

    public void translateStage() {
        if (os == MAC){

            if (WorkingTextArea.getKeyboardIsVisible()){
                System.out.println(currentState.getStage().getCamera());
                if (!stateUp)
                    currentState.getStage().getCamera().translate(0, -KEY_BOARD_HEIGHT, 0);
                stateUp = true;
            } else{
                if (stateUp)
                    currentState.getStage().getCamera().translate(0, KEY_BOARD_HEIGHT, 0);
                stateUp = false;
            }
        }

    }

    public void handleGesture(boolean gestureX, boolean gestureY, boolean magX) {
        if (currentState instanceof Gesturable)
            ((Gesturable) currentState).handleGesture(gestureX, gestureY, magX);

    }




}
