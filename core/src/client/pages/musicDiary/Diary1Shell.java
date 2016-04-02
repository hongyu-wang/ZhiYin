package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 *
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Diary1Shell extends State{

    protected void init(){
        super.init();

        Image background = new Image(new Texture("Diary/Diary1BG.png"));
        background.setBounds(0, 0, WIDTH* StateManager.M, HEIGHT* StateManager.M);

        stage.addActor(background);

        Button composeButton = new Button(this);
        composeButton.setBounds(750 - 117, 1217, 117, 117);
        composeButton.setExecutable(new ExecuteChangePage(Pages.DIARY2));
        add(composeButton);

        setBottomBar();
    }

    @Override
    public void dispose() {

    }


}
