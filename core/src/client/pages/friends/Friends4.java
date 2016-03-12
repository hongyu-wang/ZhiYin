package client.pages.friends;

import client.component.basicComponents.Image;
import client.events.ActionEvent;

public class Friends4 extends Friends4Shell{

    public void init(){
        super.init();

        Image background = new Image("Friends -4.png");
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