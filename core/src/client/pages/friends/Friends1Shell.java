package client.pages.friends;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * The shell for the Friends1 state.
 */
public abstract class Friends1Shell extends State {

    public void init(){
        super.init();

        Image background = new Image("Friends -1.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Label friendsLabel = new Label("FRIENDS");
        friendsLabel.setBounds(0, 1217, 750, 117);
        add(friendsLabel);

        Button addFriendButton = new Button(this);
        addFriendButton.setBounds(633 + 1, 1217, 117, 117);
        addFriendButton.setExecutable(new TestExecutable("add friend"));
        add(addFriendButton);

        Button recordButton = new Button(this);
        recordButton.setBounds(0 + 1, 117, 750, 117);
        recordButton.setExecutable(new TestExecutable("record"));
        add(recordButton);

        setMainButtons();
    }

    private void setMainButtons(){
        // 59 + 117 + 55 + 117 + 55 + 117 + 55 + 117 + 58

        Button homeButton = new Button(this);
        homeButton.setBounds((59) + 1, 0, 117, 117);
        homeButton.setExecutable(new TestExecutable("home"));
        add(homeButton);

        Button diaryButton = new Button(this);
        diaryButton.setBounds((59 + 117 + 55) + 1, 0, 117, 117);
        diaryButton.setExecutable(new TestExecutable("diary"));
        add(diaryButton);

        Button friendsButton = new Button(this);
        friendsButton.setBounds((59 + 117*2 + 55*2) + 1, 0, 117, 117);
        friendsButton.setExecutable(new TestExecutable("friends"));
        add(friendsButton);

        Button toolsButton = new Button(this);
        toolsButton.setBounds((59 + 117*3 + 55*3) + 1, 0, 117, 117);
        toolsButton.setExecutable(new TestExecutable("tools"));
        add(toolsButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }


}