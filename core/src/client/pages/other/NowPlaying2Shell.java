package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;


public abstract class NowPlaying2Shell extends State {
    protected void init(){
        super.init();

        Image background = new Image(new Texture("NowPlaying/NowPlayingBG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        Button picture = new Button(this);
        picture.setBounds(50, 1160 - 655, 655, 655);
        picture.setExecutable(new TestExecutable("picture"));
        add(picture);


        TestExecutable likeEx = new TestExecutable("like");
        addImageButton("NowPlaying/Like@", likeEx, 562, 1240, 144, 54);

        TestExecutable addCommentEx = new TestExecutable("add comment");
        addImageButton("NowPlaying/AddComment@", addCommentEx, 526, 1063, 51, 51);


        TestExecutable rewindEx = new TestExecutable("rewind");
        addImageButton("NowPlaying/Rewind@", rewindEx, 170, 246, 53, 46);

        TestExecutable playEx = new TestExecutable("play");
        addImageButton("NowPlaying/Play@", playEx, 288, 177, 180, 180);

        TestExecutable forwardEx = new TestExecutable("forward");
        addImageButton("NowPlaying/Forward@", forwardEx, 535, 246, 53, 46);


        TestExecutable commentEx = new TestExecutable("comment");
        addImageButton("NowPlaying/Comment@", commentEx, 0, 0, 230, 117);

        TestExecutable secEx = new TestExecutable("1s");
        addImageButton("NowPlaying/1S@", secEx, 230, 0, 290, 117);

        TestExecutable shareEx = new TestExecutable("share");
        addImageButton("NowPlaying/Share@", shareEx, 520, 0, 230, 117);
    }
}
