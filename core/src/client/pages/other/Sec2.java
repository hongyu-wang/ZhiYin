package client.pages.other;

import client.events.executables.internalChanges.TestExecutable;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Sec2 extends Sec2Shell {

    private State previousState;
    private Sec1 sec1;

    public Sec2(Sec1 sec1, State previousState){
        this.sec1 = sec1;
        this.previousState = previousState;
        init();
    }

    protected void init(){
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        ExecuteToTempState discard = new ExecuteToTempState(sec1);
        ImageButton discardButton = createImageButton("Other/Discard@", discard, 36, 57, 340, 73);

        final TestExecutable send = new TestExecutable("send");
        ImageButton sendButton = createImageButton("Other/Send2@", send, 36 + 340, 57, 339, 73);
        sendButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sec1.addPost("name", "time", send/*TODO fix*/);
                new ExecuteToTempState(sec1).execute();
            }
        });

        stage.addActor(discardButton);
        stage.addActor(sendButton);
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
