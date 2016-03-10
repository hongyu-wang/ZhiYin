package client.pages.friends;

import client.component.basicComponents.Label;
import client.events.ActionEvent;
import client.pages.State;
import client.stateInterfaces.ActionMonitor;

/**
 * The main state for the friends page.
 */
public class Friends1 extends State implements ActionMonitor{

    //private ServiceList<> friends;

    public void init(){
        super.init();

        //friends = new ServiceList<>();

        //this.components.add(new Label("FRIENDS", 200, 0, 400, 100));
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
