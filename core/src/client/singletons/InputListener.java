package client.singletons;

import client.events.ActionEvent;
import client.pageStorage.Pages;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Performable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
public class InputListener implements InputProcessor, Performable {
    /**
     * Our instance of InputListener as per the Singleton design pattern.
     */
    private static InputListener ourInstance = new InputListener();


    /**
     * This is the value of currentEvent when
     * the screen isn't pressed.
     */
    private static final int DOWN = 0;

    /**
     * This is the value of currentEvent
     * when the screen is currently pressed
     */
    private static final int UP = 1;

    /**
     * This is the value that stores the currentEvent
     * This is useful mainly because InputListener needs to implement performable
     * and thus will return the appropriate executable.
     */
    private int currentEvent = UP;





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

    private Executable [] executables;


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
        executables = new Executable[2];
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

        if (keycode == Input.Keys.Q)
            stateManager.changeState(Pages.DIARY1);

        if (keycode == Input.Keys.W)
            stateManager.changeState(Pages.DIARY2);

        if (keycode == Input.Keys.E)
            stateManager.changeState(Pages.DIARY3);

        if (keycode == Input.Keys.A)
            stateManager.changeState(Pages.HOME1);

        if (keycode == Input.Keys.S)
            stateManager.changeState(Pages.HOME2);

        if (keycode == Input.Keys.D)
            stateManager.changeState(Pages.HOME3);

        if (keycode == Input.Keys.F)
            stateManager.changeState(Pages.HOME4);

        if (keycode == Input.Keys.Z)
            stateManager.changeState(Pages.NOWPLAYING);

        if (keycode == Input.Keys.X)
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
        stateManager.actionPerformed(new ActionEvent(this));
        mouseX = screenX;
        mouseY = screenY;
        currentEvent = DOWN;

        //TODO REMOVE THIS PRINT STATEMENT
        System.out.println("x_pos: " + mouseX + " y_pos: "+  mouseY);


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        stateManager.actionPerformed(new ActionEvent(this));
        mouseX = screenX;
        mouseY = screenY;
        currentEvent = UP;


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


    @Override
    public Executable getExecutable() {
        return executables[currentEvent];
    }


}
