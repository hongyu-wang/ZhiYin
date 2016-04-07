package client.pages.other;

import client.component.basicComponents.ConfirmDialog;
import client.events.executables.internalChanges.imageGalleryExecutables.ExecuteOpenCamera;
import client.events.executables.internalChanges.imageGalleryExecutables.ExecuteOpenCameraRoll;
import client.events.executables.internalChanges.serverInteractions.*;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.musicDiary.Diary4;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Profile;
import client.tools.ImageParser;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MBand;
import server.model.user.User;
import server.model.user.UserProfile;
import server.services.factories.ImageManagerFactory;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;
import tools.utilities.Utils;
import client.component.basicComponents.Button;
import java.util.List;


/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class MyProfile extends MyProfileShell implements Profile {
    @Override
    public List<Long> getCurrentDiaries() {
        return currentDiaries;
    }

    @Override
    public List<Long> getCurrentArtists() {
        return currentArtists;
    }

    private List<Long> currentDiaries;
    private List<Long> currentArtists;

    public static String name;

    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Window profilePicChooser;

    private Table table;
    private Table following;

    private String description;

    private Image profilePic;

    private ExecuteUpdate update1;
    private ExecuteUpdate update2;
    private UserProfile userProfile;

    public MyProfile(){
        init();
    }

    private void serverInit(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        User user = localDatabase.getMainUser();
        userProfile = localDatabase.getModel(user.getProfileKey());
        MImage mImage = localDatabase.getModel(userProfile.getImageKey());

        name = userProfile.getUsername();
        this.description = userProfile.getDescription();
        this.profilePic = ImageManagerFactory.createImageManager().mImageToImage(mImage);

        currentArtists = Utils.newList();
        currentDiaries = Utils.newList();

        update1 = new ExecuteUpdateProfileArtists(this, name);
        update2 = new ExecuteUpdateProfileDiary(this, name);
    }

    protected void init(){
        super.init();
        serverInit();

        if(profilePic != null) {
            profilePic.setBounds(50*M, 967*M, 200*M, 200*M);
            stage.addActor(profilePic);
        }

        Table t = new Table();
        t.setBounds(300*M, 1000*M, 450*M, 167*M);
        t.top();
        t.add(new Label(name, SkinSingleton.getInstance())).width(450*M);
        t.row();

        Label descriptionLabel = new Label(description, SkinSingleton.getInstance());
        descriptionLabel.setWrap(true);
        t.add(descriptionLabel).width(450*M).expandX().left();

        ScrollPane s = new ScrollPane(t);
        s.setBounds(300*M, 1000*M, 450*M, 167*M);
        stage.addActor(s);

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 570*M, 750*M, 250*M);
        stage.addActor(scrollpane);

        following = new Table();
        following.top();

        scrollpane2 = new ScrollPane(following);
        scrollpane2.setBounds(50*M,  350*M, 700*M, 150*M);
        //scrollpane2.setScrollingDisabled(false, true);
        stage.addActor(scrollpane2);
        setUpWindow();

    }

    private void setUpWindow(){
        Button button = new Button(this);
        button.setBounds(280, 920, 80, 80);

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

        button.setExecutable(
                ()->stage.addActor(confirmDialog.getWindow())
        );
        add(button);
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


    @Override
    public void addPost(final MDiaryPost diaryPost){
        String title = diaryPost.getTitle();

        Table t = new Table();
        t.add(new Label(title, SkinSingleton.getInstance())).expand().left().padLeft(50*M);
        t.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26 * M).expand().right().padRight(50 * M);
        disposables.add(tx);
        t.row();
        t.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50 * M);
        disposables.add(tx);

        Stack s = new Stack();
        s.add(new Image(tx = new Texture("Home/BlackBG@1.0.png")));
        disposables.add(tx);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new Diary4(this, diaryPost, null), TransitionType.RIGHT_TO_LEFT);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750*M).height(110*M);
        table.row();
    }

    @Override
    public void addFollowing(MBand artist, Image image){
        Table t = new Table();
        Stack s = new Stack();

        final ImageButton artistButton = new ImageButton(image.getDrawable());
        final ImageButton removeButton = new ImageButton(new Image(tx = new Texture("Other/Unfollow@1.0.png")).getDrawable());
        disposables.add(tx);

        Table artistTable = new Table();
        artistTable.add(artistButton).width(150*M).height(150*M);
        s.add(artistTable);

        Table removeTable = new Table();
        removeTable.add(removeButton).width(56*M).height(56*M).expand().top().right();
        s.add(removeTable);

        final Executable ex = new ExecuteToTempState(new ArtistProfile(this, artist, image), TransitionType.FADE_IN);
        final ExecuteServer exUnFollow = new ExecuteUnFollowArtist(following, artist, currentArtists);
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                if(x >= 94*M && y>= 94*M) {
                    System.out.println("remove");
                    //TODO use these; they should work
                    exUnFollow.execute();
                    update1.execute();
                    //TODO take out the removes and re-add the artists, minus the one being removed (MBand artist)
                }
                else{
                    System.out.println("artist");
                    ex.execute();
                }
            }
        });

        t.add(s);
        following.add(t).width(150*M).height(150*M).padLeft(50*M);

        // Do not call scrollpane2.layout(). This will cause the artists to appear vertically instead of horizontally.
    }


}
