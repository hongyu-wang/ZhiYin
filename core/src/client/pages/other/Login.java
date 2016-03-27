package client.pages.other;

import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.VeryBeginningInitializer;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * #Login Page
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class Login extends State {
    private int delta = 0;
    private int delta2 = 0;
    public static final String NAME1 = "Alice";
    public static final String NAME2 = "Benny";
    public static final String NAME3 = "Cindy";
    public static final String message = "Loading Loading. Loading.. Loading...";
    public static final String [] stuff = message.split(" ");
    private Label label;
    private boolean checkPull;
    private VeryBeginningInitializer vb;
    @Override
    public void init() {
        super.init();
        final WorkingTextArea wta = new WorkingTextArea("", SkinSingleton.getInstance());
        final TextButton button = new TextButton("Login", SkinSingleton.getInstance());
        button.setBounds(0, StateManager.HEIGHT - 100, StateManager.WIDTH, 100);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String text = wta.getText().trim();
                if (text.equals(NAME1) || text.equals(NAME2) || text.equals(NAME3)) {

                    vb = TalkerFactory.VeryBeginningInitializer();
                    vb.init(text);
                    vb.pull();
                    checkPull = true;
                    button.remove();
                    label = new Label("", SkinSingleton.getInstance());
                    label.setPosition(50, StateManager.HEIGHT - 100);
                    stage.addActor(label);

                    wta.remove();
                }
            }
        });
        wta.setBounds(0, StateManager.HEIGHT - 200, StateManager.WIDTH, 100);
        stage.addActor(wta);
        stage.addActor(button);
    }


    @Override
    public void update(float dt) {
        super.update(dt);
        if (checkPull){
            if (delta%100 == 0) {


                label.setText(stuff[delta2%(stuff.length)]);
                delta2++;

            }

            if (vb.isUpdated()) {
                Pages.initClass();

                new ExecuteChangePage(Pages.HOME).execute();
            }
            else{
                vb.pull();
            }
        }
        delta ++;

    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
