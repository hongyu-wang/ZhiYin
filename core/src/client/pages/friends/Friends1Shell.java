package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.ActionEvent;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * The shell for the Friends1 state.
 */
public abstract class Friends1Shell extends State {

    public void init(){
        super.init();
        Image background = new Image("Friends -1.png");
        background.setBounds(0, 0, 750, 1334);

        add(background);
        Label friendsLabel = new Label("Friends");
        friendsLabel.setBounds(0, 1234, 750, 100);

        Button addFriendButton = new Button(this);
        addFriendButton.setBounds(650, 1234, 100, 100);
        addFriendButton.setExecutable(new TestExecutable("add friend"));

        Button toolsButton = new Button(this);
        toolsButton.setBounds(0, 0, 750, 100);
        toolsButton.setExecutable(new TestExecutable("tools"));

        Button recordButton = new Button(this);
        recordButton.setBounds(0, 100, 750, 100);
        recordButton.setExecutable(new TestExecutable("record"));

        add(friendsLabel);
        add(addFriendButton);
        add(toolsButton);
        add(recordButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}