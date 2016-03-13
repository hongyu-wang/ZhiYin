package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.component.basicComponents.Image;
import client.component.basicComponents.Label;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public class Diary1Shell extends State{

    public void init(){
        super.init();

        Image background = new Image("Diary - 1.png");
        background.setBounds(0, 0, 750, 1334);
        add(background);

        Label musicDiaryLabel = new Label("MUSIC DIARY");
        musicDiaryLabel.setBounds(0, 1217, 750, 117);
        add(musicDiaryLabel);

        Button composeButton = new Button(this);
        composeButton.setBounds(0 + 1, 117, 750, 117);
        composeButton.setExecutable(new TestExecutable("compose"));
        add(composeButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {

    }

}
