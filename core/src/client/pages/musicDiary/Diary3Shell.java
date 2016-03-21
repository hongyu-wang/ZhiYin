package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.events.executables.internalChanges.TestExecutable;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Diary3Shell extends State{

    public void init(){
        super.init();

        Image background = new Image(new Texture("Diary - 3.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button titleButton = new Button(this);
        titleButton.setBounds(0 + 1, 1112, 750, 88);
        titleButton.setExecutable(new TestExecutable("title"));
        add(titleButton);

        Button contentButton = new Button(this);
        contentButton.setBounds(0 + 1, 718, 750, 388);
        contentButton.setExecutable(new TestExecutable("content"));
        add(contentButton);

        Button SwipeToDiscardButton = new Button(this);
        SwipeToDiscardButton.setBounds(0 + 1, 398, 750, 320);
        SwipeToDiscardButton.setExecutable(new TestExecutable("swipe to discard"));
        add(SwipeToDiscardButton);

        Button pictureButton = new Button(this);
        pictureButton.setBounds(0 + 1, 134 + 135, 750, 129);
        pictureButton.setExecutable(new TestExecutable("picture"));
        add(pictureButton);

        Button videoButton = new Button(this);
        videoButton.setBounds(0 + 1, 134, 750, 135);
        videoButton.setExecutable(new TestExecutable("video"));
        add(videoButton);

        Button discardButton = new Button(this);
        discardButton.setBounds(0 + 1, 0, 375, 117);
        discardButton.setExecutable(new ExecuteChangePage(Pages.DIARY1));
        add(discardButton);

        Button postButton = new Button(this);
        postButton.setBounds(375 + 1, 0, 375, 117);
        postButton.setExecutable(new TestExecutable("post"));
        add(postButton);
    }

    @Override
    public void dispose() {

    }
}
