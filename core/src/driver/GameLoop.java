package driver;

import client.pageStorage.Pages;
import client.singletons.MainBatch;
import client.singletons.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.robovm.apple.foundation.NSBundle;

import java.util.List;

public class GameLoop extends ApplicationAdapter  {
	private StateManager stateManager;
	private SpriteBatch spriteBatch;
	private long diff, start = System.currentTimeMillis();

	public static boolean INITIALPUSH = false;

    private static OrthographicCamera primary;

	@Override
	public void create() {

		stateManager = StateManager.getInstance();
		Pages.initLogin();
        stateManager.changeState(Pages.LOGIN);
		spriteBatch = MainBatch.getInstance();
        primary = new OrthographicCamera(StateManager.WIDTH*StateManager.M, StateManager.HEIGHT*StateManager.M);
        primary.translate(primary.viewportWidth / 2, primary.viewportHeight / 2);
        primary.update();



    }







	@Override
	public void render () {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(primary.combined);

		spriteBatch.begin();
		stateManager.update(Gdx.graphics.getDeltaTime());
		stateManager.draw();

		spriteBatch.end();
		sleep(60);
	}

    @Override
    public void dispose() {
        stateManager.dispose();
    }

	public void sleep(int fps) {
		if(fps>0){
			diff = System.currentTimeMillis() - start;
			long targetDelay = 1000/fps;
			if (diff < targetDelay) {
				try{
					Thread.sleep(targetDelay - diff);
				} catch (InterruptedException e) {}
			}
			start = System.currentTimeMillis();
		}
	}
}
