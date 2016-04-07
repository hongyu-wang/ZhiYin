package client.singletons;

import client.pages.State;
import client.tools.Constants;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * This is the InputListener class.
 *
 * Due to this being an app, this class only handles touch events.
 * This class is a singleton, and should be the ONLY class that implements
 * the InputListener interface within LibGdx.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class InputListener implements InputProcessor, Constants, GestureDetector.GestureListener {
    /**
     * Our instance of InputListener as per the Singleton design pattern.
     */

    private static InputListener ourInstance = new InputListener();
    private static InputMultiplexer im = new InputMultiplexer();








    /**
     * This is the current stateManager class.
     * When the screen is touched, this class will send an action directly
     * to this stateManager. The stateManager will then pass the action directly to the state
     * that is currently active within the stateManager.
     */
    private StateManager stateManager;
    /**
     * These are the coordinates of where on the screen was pressed.
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
        init();
    }

    /**
     * This is the primary init method of our class.
     *
     */
    private void init(){
        stateManager = StateManager.getInstance();

    }

    public static void prepare(){
        im.clear();
    }

    public static void setListener(State state){
        prepare();

        im.addProcessor(new GestureDetector(getInstance()));
        im.addProcessor(state.getStage());
        im.addProcessor(InputListener.getInstance());
        Gdx.input.setInputProcessor(im);

    }

    public static InputMultiplexer getMultiplexer(){
        return im;
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
        mouseX = screenX;

        mouseY = Gdx.graphics.getHeight() - screenY;

        stateManager.receiveInput();

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseX = screenX;
        //mouseY = (int)(HEIGHT*StateManager.M) - screenY;
        mouseY = screenY;

        stateManager.receiveRelease();

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        mouseX = screenX;
        mouseY = (int)(HEIGHT*StateManager.M) - screenY;


        stateManager.receiveDragged();
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


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        System.out.println("velocityX = [" + velocityX + "], velocityY = [" + velocityY + "])");

        StateManager.getInstance().handleGesture(velocityX > 0, velocityY < 0, Math.abs(velocityX) > Math.abs(velocityY));
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }
}
