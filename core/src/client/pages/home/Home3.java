package client.pages.home;

import client.component.basicComponents.Image;
import client.events.ActionEvent;
import client.pages.State;
import driver.GameLoop;

/**
 * This is the third home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home3 extends State {
    public void init() {
        super.init();
        Image background = new Image("Home - 3.png");
        background.setBounds(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);
        add(background);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
