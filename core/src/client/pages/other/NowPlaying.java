package client.pages.other;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteMoveSlider;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.ZhiYinRealChangeListener;

import static client.singletons.StateManager.M;
/**
 * This is the now playing page as given in the
 * art assets folder.
 *
 * Picture co-ords: TopLeft: 49, 193
 *                  BottomRight:  706, 847
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class NowPlaying extends NowPlayingShell {
    private ExecuteMoveSlider executeMoveSlider;
    private State previousState;
    private Slider slider;
    private boolean verbose;

    private ImageButton pauseButton;
    private ImageButton playButton;

    public NowPlaying(State previousState){
        this.previousState = previousState;
        verbose = false;
        init();
    }

    public NowPlaying(State previousState, boolean verbose){
        this(previousState);
        this.verbose = true;
    }


    @Override
    protected void init() {
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        ExecuteToTempState showCommentsEx = new ExecuteToTempState(new NowPlaying2(previousState, this));
        addImageButton("NowPlaying/ShowComments@", showCommentsEx, 607, 1063, 51, 51);

        TestExecutable pauseEx = new TestExecutable("pause");
        pauseButton = createImageButton("NowPlaying/Pause@", pauseEx, 288, 177, 180, 180);
        pauseButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pause();
            }
        });

        TestExecutable playEx = new TestExecutable("play");
        playButton = createImageButton("NowPlaying/Play@", playEx, 288, 177, 180, 180);
        playButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                play();
            }
        });

        stage.addActor(pauseButton);

        ExecuteToTempState commentEx = new ExecuteToTempState(new Comment(this, "title", "subtitle"));
        addImageButton("NowPlaying/Comment@", commentEx, 0, 0, 230, 117);

        ExecuteToTempState secEx = new ExecuteToTempState(new Sec1(this, "title", "subtitle"));
        addImageButton("NowPlaying/1S@", secEx, 230, 0, 290, 117);

        initializeSlider();
    }

    private void pause(){
        pauseButton.remove();
        stage.addActor(playButton);
    }

    private void play(){
        playButton.remove();
        stage.addActor(pauseButton);
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {


    }

    @Override
    public void update(float dt){
        super.update(dt);
        executeMoveSlider.execute();
    }

    public void initializeSlider(){
        slider = new Slider(0, 100, 1, false, SkinSingleton.getInstance());
        slider.setBounds((int) (M * 180), (int) (M * 400), (int) (M * 410), 10);
        ZhiYinRealChangeListener zhiYinRealChangeListener;
        slider.addListener(zhiYinRealChangeListener = new ZhiYinRealChangeListener(new TestExecutable("eylmao")));
        executeMoveSlider = new ExecuteMoveSlider(slider, zhiYinRealChangeListener);

        stage.addActor(slider);
    }

}
