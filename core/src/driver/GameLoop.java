package driver;

import client.pageStorage.Pages;
import client.singletons.InputListener;
import client.singletons.MainBatch;
import client.singletons.StateManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import server.model.user.User;
import server.webservices.PostObject;

public class GameLoop extends ApplicationAdapter {
	private StateManager stateManager;
	private SpriteBatch spriteBatch;
	public static final int WIDTH = 750;

	public static final int HEIGHT = 1334;

    private static OrthographicCamera primary;

	@Override
	public void create() {
		stateManager = StateManager.getInstance();

        Pages.initClass();
        stateManager.changeState(Pages.HOME1);
		spriteBatch = MainBatch.getInstance();
        primary = new OrthographicCamera(WIDTH*StateManager.M, HEIGHT*StateManager.M);
        primary.translate(primary.viewportWidth / 2, primary.viewportHeight / 2);
        primary.update();

		InputListener.addListeners();
		Gdx.input.setInputProcessor(InputListener.getMultiplexer());


		User user = new User();
		user.setKey(1);
		user.setContent(1);

		PostObject req1 = PostObject.newInstance();

		req1.addModel(user, "User");

    }

	@Override
	public void render () {



		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        spriteBatch.setProjectionMatrix(primary.combined);

		spriteBatch.begin();
		stateManager.draw();
		stateManager.update(Gdx.graphics.getDeltaTime());
		spriteBatch.end();


	}

    @Override
    public void dispose() {
        stateManager.dispose();
    }

}
