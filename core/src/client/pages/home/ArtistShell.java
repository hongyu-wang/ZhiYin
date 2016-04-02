package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.TestExecutable;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class ArtistShell extends State{

    protected void init(){
        super.init();

        Image background = new Image(new Texture("Home/ArtistBG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);

        Button homeButton = new Button(this);
        homeButton.setBounds(0, 1217, 260, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME));
        add(homeButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(410, 1217, 340, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.DISCOVERY));
        add(discoveryButton);

//        Button searchButton = new Button(this);
//        searchButton.setBounds(26 + 1, 1146, 642, 58);
//        searchButton.setExecutable(new TestExecutable("search"));
//        add(searchButton);

//        Button sortButton = new Button(this);
//        sortButton.setBounds((750 - 75) + 1, 1146, 65, 58);
//        sortButton.setExecutable(new TestExecutable("sort"));
//        add(sortButton);

        Image i = new Image(new Texture("Home/Sort@" + StateManager.M + ".png"));
        ImageButton sortButton = new ImageButton(i.getDrawable()); //200

        sortButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new TestExecutable("sort").execute();
            }
        });

        sortButton.setPosition(688 * StateManager.M, 1159 * StateManager.M);

        stage.addActor(sortButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

}
