package client.pages.friends;

import client.component.basicComponents.Image;
import client.events.ActionEvent;

public class Friends1 extends Friends1Shell{

    //private ServiceList<> friends;

    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Image background = new Image("Friends -1.png");
        background.setBounds(0, 0, 750, 1334);

        this.components.add(background);
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
