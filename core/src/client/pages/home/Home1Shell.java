package client.pages.home;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Home1Shell extends State{

    public void init(){
        super.init();

        Image background = new Image("Home - 1.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Button artistButton = new Button(this);
        artistButton.setBounds(250 + 1, 1217, 250, 117);
        artistButton.setExecutable(new TestExecutable("artist"));
        add(artistButton);

        Button discoveryButton = new Button(this);
        discoveryButton.setBounds(500 + 1, 1217, 250, 117);
        discoveryButton.setExecutable(new TestExecutable("discovery"));
        add(discoveryButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
