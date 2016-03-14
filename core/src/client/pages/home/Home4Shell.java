package client.pages.home;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Home4Shell extends State {

    public void init(){
        super.init();

        Image background = new Image("Home - 4.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Button homeButton = new Button(this);
        homeButton.setBounds(0 + 1, 1217, 250, 117);
        homeButton.setExecutable(new TestExecutable("home"));
        add(homeButton);

        Button artistButton = new Button(this);
        artistButton.setBounds(250 + 1, 1217, 250, 117);
        artistButton.setExecutable(new TestExecutable("artist"));
        add(artistButton);

        Button searchButton = new Button(this);
        searchButton.setBounds(26 + 1, 1146, 750 - 26*2, 58);
        searchButton.setExecutable(new TestExecutable("search"));
        add(searchButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
