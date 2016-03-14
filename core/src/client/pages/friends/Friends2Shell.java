package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.ActionEvent;
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
        Label friendsLabel = new Label("Friends");
        friendsLabel.setBounds(0, 1234, 750, 100);

        Button toolsButton = new Button(this);
        toolsButton.setBounds(0, 0, 750, 100);

        Button discardButton = new Button(this);
        discardButton.setBounds(0, 100, 750, 200);

        add(friendsLabel);
        add(toolsButton);
        add(discardButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}
