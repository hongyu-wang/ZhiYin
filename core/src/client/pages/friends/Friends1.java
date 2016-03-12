package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;

public class Friends1 extends State implements ActionMonitor{

    //private ServiceList<> friends;



    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Image background = new Image("Friends -1.png");


        background.setBounds(0, 0, 750, 1350);

        Button addFriendButton = new Button(this, null);
        addFriendButton.setBounds(650, 1250, 100, 100);

        Button toolsButton = new Button(this, null);
        toolsButton.setBounds(0, 0, 750, 100);

        Button recordButton = new Button(this, null);
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
