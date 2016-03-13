package client.pages.home;

import client.component.basicComponents.Image;
import client.pages.State;

/**
 * This is the second home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home2 extends State {

    public void init() {
        super.init();
        Image background = new Image("Home - 2.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);
        setBottomBar();
    }


    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
