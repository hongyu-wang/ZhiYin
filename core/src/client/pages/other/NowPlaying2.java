package client.pages.other;

import client.component.basicComponents.Button;
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

        Button backButton = new Button(this);
        backButton.setBounds(0 + 1, 1217, 117, 117);
        //ExecutableMultiplexer executables = new ExecutableMultiplexer();
        backButton.setExecutable(new ExecuteToTempState(previousState));
        //backButton.setExecutable(executables);
        add(backButton);

        Button nowPlaying1Button = new Button(this);
        nowPlaying1Button.setBounds(607 + 1, 1063, 51, 51);
        nowPlaying1Button.setExecutable(new ExecuteToTempState(nowPlaying));
        add(nowPlaying1Button);
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
