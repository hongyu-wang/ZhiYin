package client.component.basicComponents;

import client.component.Component;
import client.events.ActionEvent;
import client.singletons.InputListener;
import client.singletons.ShapeCreater;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Dragable;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static client.singletons.StateManager.M;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class DragButton extends Component implements Dragable {
    private Executable dragExecute, releaseExecute, returnExecutable;
    private ActionMonitor monitor;
    private float limit;
    private boolean playAnimation;
    public DragButton(ActionMonitor monitor, int limit) {
        this.monitor = monitor;
        this.limit = limit * M;
    }

    @Override
    protected void init() {
        playAnimation = true;
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

    public void drag(){
        returnExecutable = dragExecute;
        if (InputListener.getInstance().getMouseY() > limit)
            monitor.actionPerformed(new ActionEvent(this));
    }

    public void release(){
        returnExecutable = releaseExecute;
        monitor.actionPerformed(new ActionEvent(this));
    }

    @Override
    public Executable getExecutable() {
        return returnExecutable;
    }


    @Override
    public void setDragExecutable(Executable e) {
        dragExecute = e;
    }

    @Override
    public void setReleaseExecutable(Executable e) {
        releaseExecute = e;
    }


    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
