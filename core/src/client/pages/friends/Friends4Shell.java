package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * The shell for the Friends4 state.
 */
public class Friends4Shell extends State {

    public void init(){
        super.init();

        Image background = new Image("Friends -4.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Button messageButton = new Button(this);
        messageButton.setBounds(0 + 1, 0, 633, 117);
        messageButton.setExecutable(new TestExecutable("message"));
        add(messageButton);

        Button sendButton = new Button(this);
        sendButton.setBounds(633 + 1, 0, 117, 117);
        sendButton.setExecutable(new TestExecutable("send"));
        add(sendButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}
