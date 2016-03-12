package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.pages.State;

/**
 * The shell for the Friends4 state.
 */
public class Friends4Shell extends State {

    public void init(){
        super.init();

        Button messageButton = new Button(this);
        messageButton.setBounds(0, 0, 650, 100);

        Button sendButton = new Button(this);
        sendButton.setBounds(650, 0, 100, 100);

        this.components.add(messageButton);
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
