package client.pages.home;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class ArtistShell extends State{

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Home/ArtistBG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);
        stage.addActor(background);

        Button homeButton = new Button(this);
        homeButton.setBounds(0, 1217, 260, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME, TransitionType.LEFT_TO_RIGHT));
        add(homeButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(410, 1217, 340, 117);
        discoveryButton.setExecutable(new ExecuteChangePage(Pages.DISCOVERY, TransitionType.RIGHT_TO_LEFT));
        add(discoveryButton);

//        Button searchButton = new Button(this);
//        searchButton.setBounds(26 + 1, 1146, 642, 58);
//        searchButton.setExecutable(new TestExecutable("search"));
//        add(searchButton);

//        Button sortButton = new Button(this);
//        sortButton.setBounds((750 - 75) + 1, 1146, 65, 58);
//        sortButton.setExecutable(new TestExecutable("sort"));
//        add(sortButton);

        TestExecutable sortEx = new TestExecutable("sort");
        addImage("Home/Sort@", sortEx, 688, 1159, 42, 32);

//        stage.addActor(sortButton);

        setBottomBar();
    }


}
