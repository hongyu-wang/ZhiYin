package client.component.basicComponents;

import client.component.Component;
import client.events.ActionEvent;
import client.internalExceptions.NoExecutableException;
import client.singletons.InputListener;
import client.singletons.ShapeCreater;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Performable;
import client.stateInterfaces.Pressable;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * This is a button component. All new buttons should extend this button. This button component
 * will have its own specific textures.
 */
public class Button extends Component implements Pressable{

    /**
     * This is the monitor that this button
     * is attached to. In general, this should be a state.
     */
    private ActionMonitor monitor;

    /**
     * This is the executable that is contained within the Button.
     *
     * This will contain the logic that the button needs to operate.
     */
    private Executable executable;


    /**
     * The primary constructor for button.
     */
    public Button(ActionMonitor monitor){
        super();
        this.monitor = monitor;

    }

    /**
     * This is the boolean that triggers the animation of the button press.
     *
     */
    private boolean playAnimation = true;


    @Override
    protected void init() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw() {
        sprite_batch.end();
        if (playAnimation){
            ShapeRenderer sr = ShapeCreater.getInstance();
            sr.setAutoShapeType(true);
            sr.setColor(1, 1, 0, 0);
            sr.begin();
            sr.rect(x, y, width, height);
            sr.end();
        }
        sprite_batch.begin();
    }

    @Override
    public void update(float dt) {

    }


    public void press() {
        monitor.actionPerformed(new ActionEvent(this));
    }

    @Override
    public Executable getExecutable() throws NoExecutableException {
        if (executable == null)
            throw new NoExecutableException();
        return executable;
    }

    @Override
    public void setExecutable(Executable ex) {
        this.executable = ex;
    }

    @Override
    public boolean isPressed() {
        InputListener il = InputListener.getInstance();

        return checkInX(il) && checkInY(il);
    }

    @Override
    public void setAnimation() {
        //playAnimation = !playAnimation;
    }


    /**
     * Helper method for is pressed
     * @param il The inputlistener instance
     * @return whether or not the button is in the width span
     */
    private boolean checkInX(InputListener il){
        return  il.getMouseX() - x > 0 && width > il.getMouseX() - x;
    }

    /**
     * Helper method for is pressed
     * @param il The inputlistener instance
     * @return whether or not the button is in the height span
     */
    private boolean checkInY(InputListener il){

        return il.getMouseY() - y > 0 && height > il.getMouseY() - y ;
    }



}
