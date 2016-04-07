package client.pages.musicDiary;

import client.component.basicComponents.Button;
import client.component.basicComponents.ConfirmDialog;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.imageGalleryExecutables.ExecuteOpenCamera;
import client.events.executables.internalChanges.imageGalleryExecutables.ExecuteOpenCameraRoll;
import client.events.executables.internalChanges.schmoferMusicExecutable.ExecuteSetDiaryPostAudio;
import client.events.executables.internalChanges.serverInteractions.ExecuteSendDiaryPost;
import client.events.executables.internalChanges.serverInteractions.ExecuteServer;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Gesturable;
import client.tools.ImageParser;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MAudio;
import server.model.media.MImage;
import server.model.media.MMusic;

/**
 * This is the second music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary2 extends Diary2Shell implements Gesturable{
    private TextField titleField;
    private TextField bodyField;

    private SongBox songBox;

    public MMusic getMusic() {
        return music;
    }

    public void setMusic(MMusic music) {
        this.music = music;
    }

    public MAudio getAudio() {
        return audio;
    }

    public void setAudio(MAudio audio) {
        this.audio = audio;
    }

    private MMusic music;
    private MAudio audio;

    public MImage getImage() {
        return image;
    }

    public void setImage(MImage image) {
        this.image = image;
    }

    private MImage image;

    public Diary2(){
        init();
    }

    protected void init() {

        super.init();

        image = new MImage();
        audio = new MAudio();
        music = new MMusic();

        addTitleField();
        addBodyField();

        Button postButton = new Button(this);
        postButton.setBounds(750 - 117, 1217, 117, 117);
        ExecuteServer e = new ExecuteSendDiaryPost(this);
        postButton.setExecutable(e);
        add(postButton);

        //------------------------------------------------------------------------------------------------------
        Image image = new Image(tx = new Texture("Friends/SwipeToDiscardButton@1.0.png"));
        disposables.add(tx);

        DragButton dragButton = new DragButton(this, 360, image, getStage());
        dragButton.setInitialBounds(20, 270, 710, 280);

        //TODO setup dragbutton.
        dragButton.setDragExecutable(new ExecutableMultiplexer(
                () -> System.out.println("Drag")
        ));

        dragButton.setReleaseExecutable(new ExecutableMultiplexer(
                new ExecuteSetDiaryPostAudio(this)
             /*
             *TODO make a new Diary4 using title, body, audio (audio may be null).
             *new ExecuteToTempState(new Diary4())
             */

        ));

        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(0, 0, 268, 264);
        holdToRecordButton.setExecutable(new ExecutableMultiplexer(
                new ExecuteAddDragButton(dragButton)
        ));
        add(holdToRecordButton);

        setUpWindow();

        Label label = new Label("Choose\n    a\n  song", SkinSingleton.getInstance());
        ExecuteToTempState toSelectSong = new ExecuteToTempState(new SongSelection(this), TransitionType.RIGHT_TO_LEFT);
        label.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                toSelectSong.execute();
            }
        });

        Table t = new Table();
        t.setBounds(489 * M, 0, 261 * M, 264 * M);
        t.add(label).center();
        stage.addActor(t);
    }

    private void setUpWindow(){
        Button pictureButton = new Button(this);
        pictureButton.setBounds(268, 0, 221, 264);

        ConfirmDialog confirmDialog = new ConfirmDialog(
                "Where do you want to get your picture from?",
                new String[]{"Gallery",
                        "Camera",
                        "Cancel"}
        );
        confirmDialog.setUpExecutables(
                new Executable[]{new ExecuteOpenCameraRoll(),
                        new ExecuteOpenCamera()}
        );

        pictureButton.setExecutable(
                () -> stage.addActor(confirmDialog.getWindow())
        );
        add(pictureButton);
    }

    private void changeBodyField(float m){
        bodyField.setBounds(0, (1102-m)*M, 750* M, m * M);
    }

    public void setSongBox(SongBox songBox){
        this.songBox = songBox;
        System.out.println(songBox);
    }

    public boolean hasSongBox(){
        System.out.println(songBox != null);
        return songBox != null;
    }

    @Override
    public void reset() {
        super.reset();
        titleField.remove();
        addTitleField();
        bodyField.remove();
        addBodyField();
    }

    public void attemptSetUpImage(){
        try{
            Image image = ImageParser.getImage();
            image.setBounds(50*M, 967*M, 200*M, 200*M);
            stage.addActor(image);
        } catch(IllegalStateException ex){
            System.out.println("Your stupid.");
        }
    }

    private void addTitleField(){
        titleField = new WorkingTextArea("Title...", SkinSingleton.getInstance());
        titleField.setPosition((0 + 1) * M, 1112 * M);
        titleField.setSize(750* M, 88 * M);

        stage.addActor(titleField);
    }

    private void addBodyField(){
        bodyField = new WorkingTextArea("Text...", SkinSingleton.getInstance());
        changeBodyField(830);

        stage.addActor(bodyField);
    }

    public String getTitle(){
        return titleField.getText();
    }

    public String getBody(){
        return bodyField.getText();
    }


    @Override
    public void update(float fy){
        super.update(fy);

        titleField.getText();//TODO something
        bodyField.getText();//TODO something
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.DIARY1, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
