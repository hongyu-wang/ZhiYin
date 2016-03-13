package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * The shell for the Friends2 state.
 */
public class Friends2Shell extends State {

    public void init(){
        super.init();

        Image background = new Image("Friends - 2.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Label friendsLabel = new Label("FRIENDS");
        friendsLabel.setBounds(0, 1217, 750, 117);
        add(friendsLabel);

        Button discardButton = new Button(this);
        discardButton.setBounds(0 + 1, 117, 750, 283);
        discardButton.setExecutable(new TestExecutable("discard"));
        add(discardButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}
