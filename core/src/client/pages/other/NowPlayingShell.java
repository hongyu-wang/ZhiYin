package client.pages.other;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.TestExecutable;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class NowPlayingShell extends State{

    protected void init(){
        super.init();




        TestExecutable likeEx = new TestExecutable("like");
        addImageButton("NowPlaying/Like@", likeEx, 562, 1240, 144, 54);


        TestExecutable rewindEx = new TestExecutable("rewind");
        addImageButton("NowPlaying/Rewind@", rewindEx, 170, 246, 53, 46);

        TestExecutable forwardEx = new TestExecutable("forward");
        addImageButton("NowPlaying/Forward@", forwardEx, 535, 246, 53, 46);

        TestExecutable shareEx = new TestExecutable("share");
        addImageButton("NowPlaying/Share@", shareEx, 520, 0, 230, 117);
    }


    @Override
    public void dispose() {

    }

}
