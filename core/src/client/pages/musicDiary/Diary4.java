package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.other.Comment;
import client.pages.other.Sec1;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import server.model.media.MImage;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.services.factories.ImageManagerFactory;

/**
 * Diary4 page.
 *
 * Created by Hongyu Wang on 3/19/2016.
 */
public class Diary4 extends Diary4Shell{
    MDiaryPost thisPost;


    private String title;
    private String content;
    private Image image;

    public Diary4(MDiaryPost thisPost){

        this.thisPost = thisPost;

        populateFromServer();

        init();
    }


    protected void init(){
        super.init();
        ExecuteToTempState toComment = new ExecuteToTempState(new Comment(this, thisPost));
        addImageButton("Diary/Comment@", toComment, 420, 100, 140, 140);

        ExecuteToTempState toSec = new ExecuteToTempState(new Sec1(this, thisPost));
        addImageButton("Diary/Sec@", toSec, 590, 100, 140, 140);

        Table table = new Table();
        Label label1 = new Label(title, SkinSingleton.getInstance());
        Label label2 = new Label(content, SkinSingleton.getInstance());
        label2.setWrap(true);
        label2.setWidth(750 * StateManager.M);
        table.add(label1).expand();
        table.row();
        table.add(label2).width(750*StateManager.M);

        if(image != null){
            table.row();
            table.add(image);
        }

        stage.addActor(table);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void reset() {

    }


    private void populateFromServer(){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        MText text = ms.getModel(thisPost.getText());

        this.title = thisPost.getTitle();
        this.content = text.getText();

        MImage image = ms.getModel(thisPost.getImageKey());
        this.image = ImageManagerFactory.createImageManager().mImageToImage(image);
    }

}
