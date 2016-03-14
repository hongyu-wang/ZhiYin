package driver;

import client.singletons.InputListener;
import client.singletons.MainBatch;
import client.singletons.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class GameLoop extends ApplicationAdapter {
	private StateManager stateManager;
	private SpriteBatch spriteBatch;
	private static OrthographicCamera primary;
	public static final int WIDTH = 750;

	public static final int HEIGHT = 1334;


	@Override
	public void create () {
		stateManager = StateManager.getInstance();
		spriteBatch = MainBatch.getInstance();
        primary = new OrthographicCamera(WIDTH*(float)StateManager.M, HEIGHT*(float)StateManager.M);
        primary.translate(primary.viewportWidth/2, primary.viewportHeight/2);
        primary.update();
		Gdx.input.setInputProcessor(InputListener.getInstance());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        spriteBatch.setProjectionMatrix(primary.combined);

		spriteBatch.begin();
		stateManager.draw();
		stateManager.update(Gdx.graphics.getDeltaTime());
		spriteBatch.end();

        spriteBatch.setProjectionMatrix(stateManager.getCamera());
        spriteBatch.begin();
        stateManager.drawScrolled();
        spriteBatch.end();
	}

    @Override
    public void dispose() {
        stateManager.dispose();
    }


    /**
     * @return the current camera used
     */
    public static Matrix4 getPrimary(){
        return primary.combined;
    }
}
