package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public class Diary2Shell extends State {

    public void init(){
        super.init();

        Image background = new Image("Diary - 2.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Label composeLabel = new Label("COMPOSE");
        composeLabel.setBounds(0, 1217, 750, 117);
        add(composeLabel);

        Button discardButton = new Button(this);
        discardButton.setBounds(0 + 1, 0, 375, 117);
        discardButton.setExecutable(new TestExecutable("discard"));
        add(discardButton);

        Button postButton = new Button(this);
        postButton.setBounds(375 + 1, 0, 375, 117);
        postButton.setExecutable(new TestExecutable("post"));
        add(postButton);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }
}
