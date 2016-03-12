package client.pages.friends;

import client.component.basicComponents.Image;
import client.events.ActionEvent;

public class Friends3 extends Friends3Shell{

    //private ServiceList<> friends;

    public void init(){
        super.init();

        //friends = new ServiceList<>();

        Image background = new Image("Friends - 3.png");
        background.setBounds(0, 0, 750, 1334);

        add(background);
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
