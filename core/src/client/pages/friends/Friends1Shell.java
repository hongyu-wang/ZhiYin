package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Label;
import client.events.ActionEvent;
import client.pages.State;

/**
 * The shell for the Friends1 state.
 */
public abstract class Friends1Shell extends State {

    public void init(){
        super.init();

        Label friendsLabel = new Label("Friends");
        friendsLabel.setBounds(0, 1234, 750, 100);

        Button addFriendButton = new Button(this, null);
        addFriendButton.setBounds(650, 1234, 100, 100);

        Button toolsButton = new Button(this, null);
        toolsButton.setBounds(0, 0, 750, 100);

        Button recordButton = new Button(this, null);
        recordButton.setBounds(0, 100, 750, 100);

        this.components.add(friendsLabel);
        this.components.add(addFriendButton);
        this.components.add(toolsButton);
        this.components.add(recordButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}