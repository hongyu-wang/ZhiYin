package client.singletons;

import client.events.ActionEvent;
import client.stateInterfaces.Performable;
import com.badlogic.gdx.InputProcessor;

/**
 * This is the InputListener class.
 *
 * Due to this being an app, this class only handles touch events.
 * This class is a singleton, and should be the ONLY class that implements
 * the InputListener interface within LibGdx.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class InputListener implements InputProcessor, Performable{
    /**
     * Our instance of InputListener as per the Singleton design pattern.
     */
    private static InputListener ourInstance = new InputListener();


    /**
     * This is the current stateManager class.
     * When the screen is touched, this class will send an action directly
     * to this stateManager. The stateManager will then pass the action directly to the state
     * that is currently active within the stateManager.
     */
    private StateManager stateManager;

    /**
     * These are the coordinates of the mouse on the screen updated
     * when the button is pressed.
     */
    private int mouseX, mouseY;


    /**
     * Returns the mouse x position bottom left on the screen
     * @return the current mouseX position based on the bottom left
     */
    public int getMouseX(){
        return mouseX;
    }


    /**
     * Returns the mouse y position bottom left on the screen
     * @return the current mouseY position based on the bottom left
     */
    public int getMouseY(){
        return mouseY;
    }

    /**
     * Returns the singleton instance of InputListener
     * @return Singleton instance of InputListener
     */
    public static InputListener getInstance() {
        return ourInstance;
    }

    private InputListener() {
        stateManager = StateManager.getInstance();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        stateManager.actionPerformed(new ActionEvent(this));
        mouseX = screenX;
        mouseY = screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
