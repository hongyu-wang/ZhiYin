package client.pages.other;

import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.VeryBeginningInitializer;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
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
    public static final String NAME1 = "Alice";
    public static final String NAME2 = "Benny";
    public static final String NAME3 = "Cindy";
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

                    stage.addActor(label = new Label("FUCK YOU", SkinSingleton.getInstance()));
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
            vb.update(dt);
            if (label.getText().equals("FUCK YOU..."))
                label.setText("FUCK YOU");
            else
                label.setText(label.getText()+".");
            if (vb.isUpdated())
                new ExecuteChangePage(Pages.HOME1).execute();
        }

    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
