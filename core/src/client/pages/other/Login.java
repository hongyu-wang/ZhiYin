package client.pages.other;

import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.loginExecutable.ExecuteLogin;
import client.events.executables.internalChanges.loginExecutable.ExecuteRemoveButton;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.VeryBeginningInitializer;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.Texture;
import driver.GameLoop;
import static client.singletons.StateManager.M;

/**
 * #Login Page
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class Login extends State {
    private int delta = 0;
    private int delta2 = 0;
    private WorkingTextArea username;
    private WorkingTextArea password;
    private ExecuteRemoveButton erb;

    public static final String NAME1 = "Alice";
    public static final String NAME2 = "Benny";
    public static final String NAME3 = "Cindy";
    public static final String message = "Loading Loading. Loading.. Loading...";
    public static final String [] stuff = message.split(" ");
    private Label label;
    private boolean checkPull;
    private VeryBeginningInitializer vb;


    public Login(){
        init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        String text = username.getText().trim();
        if (text.equals(NAME1) || text.equals(NAME2) || text.equals(NAME3)) {
            for (Actor act : stage.getActors()){
                act.remove();
            }
            vb = TalkerFactory.VeryBeginningInitializer();
            vb.init(text);
            vb.pull();
            checkPull = true;
            for (Actor act : stage.getActors()) {
                act.remove();
            }
            erb.execute();
            label = new Label("", SkinSingleton.getInstance());
            label.setPosition(50, StateManager.HEIGHT - 100);
            stage.addActor(label);

            //TODO Do something with IP. Check its valid? Use the password field.
        }
    }

    @Override
    protected void init() {
        super.init();

        initializeComponents();
    }

    private void initializeComponents(){
        Image image = new Image(new Texture("Artboards//Log in.png"));
        image.setBounds(0, 0, GameLoop.WIDTH * M, GameLoop.HEIGHT * M);
        stage.addActor(image);
        username = new WorkingTextArea("username", SkinSingleton.getInstance());
        password = new WorkingTextArea("server ip", SkinSingleton.getInstance());

        username.setBounds(102 * M, (GameLoop.HEIGHT - 798 - 72) * M, 545 * M, 72 * M);
        password.setBounds(102 * M, (GameLoop.HEIGHT - 910 - 72) * M, 545 * M, 72 * M);


        stage.addActor(username);
        stage.addActor(password);

        Button button = new Button(this);

        button.setExecutable(new ExecuteLogin());
        erb = new ExecuteRemoveButton(button);
        button.setBounds(302, GameLoop.HEIGHT - 1079 - 77, 153, 77);
        add(button);
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if (label != null && delta%10 == 0){
            label.setText(stuff[delta2%(stuff.length)]);
            delta2 ++;
        }
        if (checkPull){
            if (delta%100 == 0) {


                pullFromServer();
            }
        }
        delta ++;

    }

    private void pullFromServer(){
        vb.update(0);
        if (vb.isUpdated()) {
            Pages.initClass();

            new ExecuteChangePage(Pages.HOME).execute();
        }
        else{
            vb.pull();
        }
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
