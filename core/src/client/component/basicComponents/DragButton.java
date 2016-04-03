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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import static client.singletons.StateManager.M;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public class DragButton extends Component implements Dragable {
    private Executable dragExecute, releaseExecute, returnExecutable;
    private ActionMonitor monitor;
    private float limit;
    private boolean disable;
    private boolean playAnimation;
    private long begin;
    public boolean remove = false;
    private Image image;
    private Stage stage;

    private float iniX, iniY, iniWidth, iniHeight;

    public DragButton(ActionMonitor monitor, int limit, Image image, Stage stage) {
        this.monitor = monitor;
        this.limit = limit * M;
        this.image = image;
        this.stage = stage;
        hide();

    }

    @Override
    protected void init() {
        playAnimation = true;
        begin = 0;
        disable = true;
    }


    public void show(){
        disable = false;
        this.setBounds(iniX, iniY, iniWidth, iniHeight);
        stage.addActor(image);
        begin = System.currentTimeMillis();
        reset();
    }

    private void hide(){
        this.setBounds(0, 0, 0, 0);
        image.remove();
    }


    public void setInitialBounds(float x, float y, float width, float height){
        iniX = x; iniY = y; iniWidth = width; iniHeight = height;
        image.setBounds(iniX * M, iniY * M, iniWidth * M, iniHeight * M);
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
        if (InputListener.getInstance().getMouseY() > limit && !disable) {
            monitor.actionPerformed(new ActionEvent(this));
            disable = true;
            setBounds(0, 0, 0, 0);
            hide();
        }
    }

    public void release(){
        if (System.currentTimeMillis() - begin > 200 && !disable){
            returnExecutable = releaseExecute;
            push();

        } else if (!disable){
            returnExecutable = dragExecute;
            push();

        }

    }

    private void push(){
        monitor.actionPerformed((new ActionEvent(this)));
        disable = true;
        hide();
    }

    private void reset(){
        disable = false;
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
