package client.singletons;

import client.pageStorage.Pages;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import driver.GameLoop;

/**
 * This is the InputListener class.
 *
 * Due to this being an app, this class only handles touch events.
 * This class is a singleton, and should be the ONLY class that implements
 * the InputListener interface within LibGdx.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class InputListener implements InputProcessor {
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

    public static void setListener(Pages page){
        im.clear();
        im.addProcessor(page.getStateReference().getStage());
        im.addProcessor(InputListener.getInstance());
        Gdx.input.setInputProcessor(im);

    }

    public static InputMultiplexer getMultiplexer(){
        return im;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.NUM_1)
            stateManager.changeState(Pages.FRIENDS1);

        if (keycode == Input.Keys.NUM_2)
            stateManager.changeState(Pages.FRIENDS2);

        if (keycode == Input.Keys.NUM_3)
            stateManager.changeState(Pages.FRIENDS3);

        if (keycode == Input.Keys.NUM_4)
            stateManager.changeState(Pages.FRIENDS4);

        if (keycode == Input.Keys.NUM_5)
            stateManager.changeState(Pages.FRIENDS5);

        if (keycode == Input.Keys.Q)
            stateManager.changeState(Pages.DIARY1);

        if (keycode == Input.Keys.W)
            stateManager.changeState(Pages.DIARY2);

        if (keycode == Input.Keys.E)
            stateManager.changeState(Pages.DIARY3);

        if (keycode == Input.Keys.R)
            stateManager.changeState(Pages.DIARY4);

        if (keycode == Input.Keys.A)
            stateManager.changeState(Pages.HOME1);

        if (keycode == Input.Keys.S)
            stateManager.changeState(Pages.HOME3);

        if (keycode == Input.Keys.D)
            stateManager.changeState(Pages.HOME4);

        if (keycode == Input.Keys.X)
            stateManager.changeState(Pages.NOWPLAYING);

        if (keycode == Input.Keys.C)
            stateManager.changeState(Pages.NOWPLAYING2);

        if (keycode == Input.Keys.Z)
            stateManager.changeState(Pages.PROFILE);


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
        mouseY = (int)(GameLoop.HEIGHT*StateManager.M) - screenY;

        System.out.println(mouseX + " " + mouseY);
        stateManager.receiveInput();

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        mouseX = screenX;
        mouseY = (int)(GameLoop.HEIGHT*StateManager.M) - screenY;
        stateManager.recieveRelease();

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        mouseX = screenX;
        mouseY = (int)(GameLoop.HEIGHT*StateManager.M) - screenY;


        stateManager.recieveDragged();
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
