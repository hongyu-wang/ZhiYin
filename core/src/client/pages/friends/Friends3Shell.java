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

        Button discardButton = new Button(this);
        discardButton.setBounds(0, 0, 375, 100);

        Button sendButton = new Button(this);
        sendButton.setBounds(375, 0, 375, 100);

        add(friendsLabel);
        add(discardButton);
        add(sendButton);
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
