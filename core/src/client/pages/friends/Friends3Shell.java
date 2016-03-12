package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Label;
import client.events.ActionEvent;
import client.pages.State;

/**
 * The shell for the Friends3 state.
 */
public class Friends3Shell extends State {

    public void init(){
        super.init();

        Label friendsLabel = new Label("Friends");
        friendsLabel.setBounds(0, 1234, 750, 100);

        Button discardButton = new Button(this, null);
        discardButton.setBounds(0, 0, 375, 100);

        Button sendButton = new Button(this, null);
        sendButton.setBounds(375, 0, 375, 100);

        this.components.add(friendsLabel);
        this.components.add(discardButton);
        this.components.add(sendButton);
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
