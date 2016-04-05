package client.pages.other;

import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.events.executables.internalChanges.loginExecutable.ExecuteLogin;
import client.events.executables.internalChanges.loginExecutable.ExecuteRemoveButton;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import tools.serverTools.databases.LocalDatabase;
import client.pages.pageInternal.serverClientInteractions.TalkerFactory;
import client.pages.pageInternal.serverClientInteractions.VeryBeginningInitializer;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**
 * #Login Page
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class Login extends State {
    private int delta = 0;
    private WorkingTextArea username;
    private WorkingTextArea password;
    private ExecuteRemoveButton erb;

    public static final String NAME1 = "alice";
    public static final String NAME2 = "benny";
    public static final String NAME3 = "cindy";
    private Label label;
    private boolean checkPull;
    private VeryBeginningInitializer vb;



    public Login(){
        init();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String text = username.getText().trim().toLowerCase();
        if (text.equals(NAME1) || text.equals(NAME2) || text.equals(NAME3)) {
            for (Actor act : stage.getActors()){
                act.remove();
            }
            LocalDatabase.ipAddress = password.getText();

            vb = TalkerFactory.VeryBeginningInitializer();
            vb.init(text.substring(0, 1).toUpperCase() + text.substring(1));
            vb.pull();
            vb.push();
            checkPull = true;
            for (Actor act : stage.getActors()) {
                act.remove();
            }
            erb.execute();
            label = new Label("", SkinSingleton.getInstance());
            label.setPosition(50, StateManager.HEIGHT - 100);
            stage.addActor(label);
        }
    }

    @Override
    protected void init() {
        super.init();
        initializeComponents();
    }

    private void initializeComponents(){
        Image image = new Image(new Texture("Artboards//LoginPage.png"));
        image.setBounds(0, 0, WIDTH * M, HEIGHT * M);
        stage.addActor(image);
        username = new WorkingTextArea("Alice", SkinSingleton.getInstance());
        password = new WorkingTextArea("localhost", SkinSingleton.getInstance());


        username.setBounds(102 * M, (HEIGHT - 798 - 72) * M, 545 * M, 72 * M);
        password.setBounds(102 * M, (HEIGHT - 910 - 72) * M, 545 * M, 72 * M);

        stage.addActor(username);
        stage.addActor(password);

        Button button = new Button(this);

        button.setExecutable(new ExecuteLogin());
        erb = new ExecuteRemoveButton(button);
        button.setBounds(302, HEIGHT - 1079 - 77, 153, 77);
        add(button);
    }

    @Override
    public void update(float dt) {
        super.update(dt);

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
    public void dispose() {

    }


    public void setText(String str){
        label.setText(str);
    }
}
