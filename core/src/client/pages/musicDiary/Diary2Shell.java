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
public abstract class Diary2Shell extends State {

    protected void init(){
        super.init();

        Image background = new Image(tx = new Texture("Diary/Diary2BG.png"));
        disposables.add(tx);
        background.setBounds(0, 0, WIDTH*M, HEIGHT*M);
        stage.addActor(background);

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteChangePage(Pages.DIARY1, TransitionType.LEFT_TO_RIGHT));
        add(backButton);

//        Button recordButton = new Button(this);
//        recordButton.setBounds(76, 33, 174, 204);
//        recordButton.setExecutable(new ExecuteChangePage(Pages.DIARY3));
//        add(recordButton);

//        Button titleButton = new Button(this);
//        titleButton.setBounds(0 + 1, 1112, 750, 88);
//        titleButton.setExecutable(new TestExecutable("title"));
//        add(titleButton);
//
//        Button contentButton = new Button(this);
//        contentButton.setBounds(0 + 1, 553, 750, 555);
//        contentButton.setExecutable(new TestExecutable("content"));
//        add(contentButton);
//
//        Button HoldToRecordButton = new Button(this);
//        HoldToRecordButton.setBounds(0 + 1, 134 + 135*2, 750, 135);
//        HoldToRecordButton.setExecutable(new ExecuteChangePage(Pages.DIARY3));
//        add(HoldToRecordButton);
//
//        Button pictureButton = new Button(this);
//        pictureButton.setBounds(0 + 1, 134 + 135, 750, 135);
//        pictureButton.setExecutable(new TestExecutable("picture"));
//        add(pictureButton);
//
//        Button videoButton = new Button(this);
//        videoButton.setBounds(0 + 1, 134, 750, 135);
//        videoButton.setExecutable(new TestExecutable("video"));
//        add(videoButton);
//
//        Button discardButton = new Button(this);
//        discardButton.setBounds(0 + 1, 0, 375, 117);
//        discardButton.setExecutable(new ExecuteChangePage(Pages.DIARY1));
//        add(discardButton);
//
    }



}
