package client.component.basicComponents;

import client.component.Component;
import client.events.ActionEvent;
import client.internalExceptions.NoExecutableException;
import client.singletons.InputListener;
import client.singletons.ShapeCreater;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Pressable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * This is a button component. All new buttons should extend this button. This button component
 * will have its own specific textures.
 */
public class Button extends Component implements Pressable{

    private ActionMonitor monitor;
    private Executable executable;

    public Button(ActionMonitor monitor){
        super();
        this.monitor = monitor;
    }

    @Override
    protected void init() {
    }



    public void draw(Batch sb, float parentAlpha) {
        super.draw(sb, parentAlpha);
        spriteBatch.end();
        if (playAnimation){
            ShapeRenderer sr = ShapeCreater.getInstance();
            sr.setAutoShapeType(true);
            sr.setColor(1, 1, 0, 0);
            sr.begin();
            sr.rect(getX(), getY(), getWidth(), getHeight());
            sr.end();
        }
        spriteBatch.begin();
    }

    @Override
    public void update(float dt) {

    }


    public void press() {
        monitor.actionPerformed(new ActionEvent(this));
    }

    @Override
    public void release() {


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



    /**
     * Helper method for is pressed
     * @param il The inputlistener instance
     * @return whether or not the button is in the width span
     */
    private boolean checkInX(InputListener il){
        return  il.getMouseX() - getX() > 0 && getWidth() > il.getMouseX() - getX();
    }

    /**
     * Helper method for is pressed
     * @param il The inputlistener instance
     * @return whether or not the button is in the height span
     */
    private boolean checkInY(InputListener il){

        return il.getMouseY() - getY() > 0 && getHeight() > il.getMouseY() - getY();
    }



}
