package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteToTempState;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is the profile page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class ArtistProfile extends ArtistProfileShell {

    State previousState;

    String artistName;

    Table table;

    public ArtistProfile(State previousState, String artistName){
        this.previousState = previousState;
        this.artistName = artistName;
        init();
    }


    public void init() {
        super.init();

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217 * StateManager.M, 117 * StateManager.M, 117 * StateManager.M);
        backButton.setExecutable(new ExecuteToTempState(previousState));
        add(backButton);

        Image i = new Image(new Texture("Other/Follow@" + StateManager.M + ".png"));
        final ImageButton followButton = new ImageButton(i.getDrawable());
        followButton.setPosition(500 * StateManager.M, 70 * StateManager.M);

        followButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("follow").execute();
            }
        });

        stage.addActor(followButton);

        table = new Table();
        table.setBounds(0, 200 * StateManager.M, 750 * StateManager.M, 1017 * StateManager.M);
        table.top();

        Label artist = new Label(artistName, SkinSingleton.getInstance());

        table.add(artist);

        stage.addActor(table);

        table.setDebug(true);

    }

    @Override
    public void reset() {

    }


    @Override
    public void dispose() {

    }

}
