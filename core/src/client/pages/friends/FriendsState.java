package client.pages.friends;

import client.component.Component;
import client.component.basicComponents.Label;
import client.pages.State;
import tools.ServiceList;

/**
 * The main state for the friends page.
 */
public class FriendsState extends State{

    private ServiceList<Friend> friends;


    public FriendsState(){
        super.init();
        init();
    }

    public void init(){
        friends = new ServiceList<>();

        this.components.add(new Label("FRIENDS", 200, 0, 400, 100));
    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw() {
        for(Component c : this.components){
            c.draw();
        }

    }

    @Override
    public void update(float dt) {

    }
}
