package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.other.TransitionType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 *
 * Created by blobbydude24 on 2016-03-13.
 */
public abstract class Diary1Shell extends State{

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Diary/Diary1BG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);

        stage.addActor(background);

        Button composeButton = new Button(this);
        composeButton.setBounds(750 - 117, 1217, 117, 117);
        composeButton.setExecutable(new ExecuteChangePage(Pages.DIARY2, TransitionType.RIGHT_TO_LEFT));
        add(composeButton);

        setBottomBar();
    }




}
