package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;

public class Friends3 extends State implements ActionMonitor{

    //private ServiceList<> friends;



    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Image background = new Image("Friends - 3.png");
        background.setBounds(0, 0, 750, 1350);

        Button discardButton = new Button(this);
        discardButton.setBounds(0, 0, 375, 100);

        Button sendButton = new Button(this);
        sendButton.setBounds(375, 0, 375, 100);

        this.components.add(background);
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
