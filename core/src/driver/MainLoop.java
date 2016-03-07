package driver;

import client.MainBatch;
import client.PageManager.Pages;
import client.PageManager.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainLoop extends ApplicationAdapter {
	private StateManager state_manager;
	private SpriteBatch sprite_batch;

	@Override
	public void create () {
		state_manager = new StateManager(Pages.MAIN);
		sprite_batch = MainBatch.getInstance();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sprite_batch.begin();
		state_manager.draw();
		state_manager.update(Gdx.graphics.getDeltaTime());
		sprite_batch.end();
	}

    @Override
    public void dispose() {
        state_manager.dispose();
    }
}
