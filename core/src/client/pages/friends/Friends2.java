package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Label;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;

/**
 * The main state for the friends page.
 */
public class Friends2 extends State implements ActionMonitor{

    //private ServiceList<> friends;



    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Label background = new Label("Friends - 1.png");
        background.setBounds(0, 0, 750, 1350);

        Button addFriendButton = new Button(this);
        addFriendButton.setBounds(700, 1300, 50, 50);

        Button toolsButton = new Button(this);
        toolsButton.setBounds(0, 0, 750, 100);

        Button recordButton = new Button(this);
        recordButton.setBounds(0, 100, 750, 100);

        this.components.add(background);
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