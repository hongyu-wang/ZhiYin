package client.pages.other;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

/**
 * Created by Hongyu Wang on 3/19/2016.
 */
public class NowPlaying2 extends NowPlaying2Shell {
    float count = 0;
    Slider slider;

    State previousState;
    NowPlaying nowPlaying;

    public NowPlaying2(State previousState, NowPlaying nowPlaying){
        this.previousState = previousState;
        this.nowPlaying = nowPlaying;
        init();
    }

    protected void init(){
        super.init();
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());

        float m = StateManager.M;
        slider.setBounds((int)(m*180), (int)(m*400), (int)(m*410), 10);

        stage.addActor(slider);

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlayingMarch27/Back@", backEx, 0, 1217, 117, 117);

        ExecuteToTempState hideCommentsEx = new ExecuteToTempState(nowPlaying);
        addImageButton("NowPlayingMarch27/ShowComments@", hideCommentsEx, 607, 1063, 51, 51);

        TestExecutable pauseEx = new TestExecutable("pause");
        addImageButton("NowPlayingMarch27/Pause@", pauseEx, 288, 177, 180, 180);

//        TestExecutable playEx = new TestExecutable("play");
//        addImageButton("NowPlayingMarch27/Play@", playEx, 288, 177, 180, 180);

    }




    @Override
    public void dispose() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void update(float dt) {
        super.update(dt);

    }
}
