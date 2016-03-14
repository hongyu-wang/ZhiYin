package client.pages.home;

import client.stateInterfaces.Scrollable;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * This is the first home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home1 extends Home1Shell implements Scrollable {
    private OrthographicCamera cam;
    
    public void init() {
        super.init();
        cam = new OrthographicCamera();
    }


    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void drawScrolled() {

    }

    @Override
    public Matrix4 getCamera() {
        return cam.combined;
    }
}
