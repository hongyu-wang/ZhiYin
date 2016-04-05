package client.pages.other;

import client.events.executables.internalChanges.serverInteractions.*;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.musicDiary.Diary4;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.stateInterfaces.Profile;
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

    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;
    private String description;

    private Image profilePic;

    private ExecuteUpdate update1;
    private ExecuteUpdate update2;

    //private ArrayList<Image> artistImages = new ArrayList<>();
    //private ArrayList<ImageButton> artistButtons = new ArrayList<>();
    //private ArrayList<ImageButton> removeButtons = new ArrayList<>();

    public MyProfile(){
//        pull from server for name and image
        init();
    }

    private void serverInit(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        User user = localDatabase.getMainUser();
        UserProfile userProfile = localDatabase.getModel(user.getProfile());
        MImage mImage = localDatabase.getModel(userProfile.getImageKey());

        this.name = userProfile.getUsername();
        this.description = "here is a really long description that I am typing just to test wrapping of the words, as well as scrollpane vertical scrolling;" +
        "more redundant words are being typed right now and stuff and stuff and stuff and more stuff and more stuff and more stuff and more stuff";
        this.profilePic = ImageManagerFactory.createImageManager().mImageToImage(mImage);

        currentArtists = Utils.newList();
        currentDiaries = Utils.newList();

        update1 = new ExecuteUpdateProfileArtists(this, name);
        update2 = new ExecuteUpdateProfileDiary(this, name);
    }

    protected void init(){
        super.init();
        serverInit();

        Label label = new Label(name, SkinSingleton.getInstance());
        label.setPosition(310*M, 1050*M);
        stage.addActor(label);

        if(profilePic != null) {
            profilePic.setBounds(50*M, 967*M, 200*M, 200*M);
            stage.addActor(profilePic);
        }

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0,  570*M, 750*M, 250*M);
        stage.addActor(scrollpane);

        following = new Table();
        following.top();

        scrollpane2 = new ScrollPane(following);
        scrollpane2.setBounds(50*M,  350*M, 700*M, 150*M);
        stage.addActor(scrollpane2);

    }

    @Override
    public void addPost(final MDiaryPost diaryPost){
        Stack s = new Stack();

        Table t = new Table();

        String title = diaryPost.getTitle();

        Label single = new Label(title, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + M + ".png"));

        t.add(single).expand().left().padLeft(10*M);
        t.add(i).expand().right().padRight(50*M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + M + ".png"));

        s.add(i2);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new Diary4(this, diaryPost));
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
        final ImageButton removeButton = new ImageButton(new Image(new Texture("Other/Unfollow@1.0.png")).getDrawable());

        Table artistTable = new Table();
        artistTable.add(artistButton).width(150*M).height(150*M);
        s.add(artistTable);

        Table removeTable = new Table();
        removeTable.add(removeButton).width(56*M).height(56*M).expand().top().right();
        s.add(removeTable);

        final Executable ex = new ExecuteToTempState(new ArtistProfile(this, artist, image));
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
                    artistButton.remove();
                    removeButton.remove();
                }
                else{
                    System.out.println("artist");
                    ex.execute();
                }
            }
        });

        t.add(s);
        following.add(t).width(150*M).height(150*M).padLeft(50*M);
    }


    @Override
    public void dispose() {

    }
}
