package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.pageStorage.Pages;
import client.pages.State;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import driver.GameLoop;

/**
 * Stuff
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public abstract class Diary4Shell extends State {

    protected void init(){
        super.init();
        Image background = new Image(new Texture("Diary/Diary4BG.png"));
        background.setBounds(0, 0, GameLoop.WIDTH* StateManager.M, GameLoop.HEIGHT* StateManager.M);
        stage.addActor(background);

        ExecuteChangePage changePage = new ExecuteChangePage(Pages.DIARY1);
        addImageButton("NowPlaying/Back@", changePage, 0, 1217, 117, 117);
    }

    @Override
    public void dispose() {

    }
}
