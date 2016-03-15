package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.events.executables.internalChanges.TestExecutable;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Home3Shell extends State{

    public void init(){
        super.init();

        Image background = new Image(new Texture("Home - 3.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        add(background);

        Button homeButton = new Button(this);
        homeButton.setBounds(0 + 1, 1217, 250, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME1));
        add(homeButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(500 + 1, 1217, 250, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.HOME4));
        add(discoveryButton);

        Button searchButton = new Button(this);
        searchButton.setBounds(26 + 1, 1146, 642, 58);
        searchButton.setExecutable(new TestExecutable("search"));
        add(searchButton);

        Button sortButton = new Button(this);
        sortButton.setBounds((750 - 75) + 1, 1146, 65, 58);
        sortButton.setExecutable(new TestExecutable("sort"));
        add(sortButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

}