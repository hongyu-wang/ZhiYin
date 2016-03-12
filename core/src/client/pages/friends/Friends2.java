package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;

public class Friends2 extends State implements ActionMonitor{

    //private ServiceList<> friends;



    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Image background = new Image("Friends - 2.png");
        background.setBounds(0, 0, 750, 1350);

        Button toolsButton = new Button(this, null);
        toolsButton.setBounds(0, 0, 750, 100);

        Button discardButton = new Button(this, null);
        discardButton.setBounds(0, 100, 750, 200);

        this.components.add(background);
        this.components.add(toolsButton);
        this.components.add(discardButton);
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