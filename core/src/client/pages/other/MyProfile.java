package client.pages.other;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.musicDiary.Diary4;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.social.MDiaryPost;
import server.model.user.UserProfile;
import server.services.factories.ImageManagerFactory;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class MyProfile extends MyProfileShell {
    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;

    private Image profilePic;

    //private ArrayList<Image> artistImages = new ArrayList<>();
    //private ArrayList<ImageButton> artistButtons = new ArrayList<>();
    //private ArrayList<ImageButton> removeButtons = new ArrayList<>();

    public MyProfile(){
//        pull from server for name and image
        init();
    }

    private void serverInit(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        UserProfile userProfile = localDatabase.getModel(localDatabase.getMainUser().getProfile());
        MImage mImage = localDatabase.getModel(userProfile.getImageKey());

        this.name = userProfile.getUsername();
        this.profilePic = ImageManagerFactory.createImageManager().mImageToImage(mImage);
    }

    protected void init(){

        super.init();
        serverInit();

        Label label = new Label(name, SkinSingleton.getInstance());
        label.setPosition(310 * StateManager.M, 1050 * StateManager.M);
        stage.addActor(label);

        if(profilePic != null) {
            profilePic.setBounds(50 * StateManager.M, 967 * StateManager.M, 200 * StateManager.M, 200 * StateManager.M);
            stage.addActor(profilePic);
        }

        table = new Table();
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0,  570 * StateManager.M, 750 * StateManager.M, 250 * StateManager.M);
        stage.addActor(scrollpane);

        following = new Table();
        following.top();

        scrollpane2 = new ScrollPane(following);
        scrollpane2.setBounds(50 * StateManager.M,  350 * StateManager.M, 700 * StateManager.M, 150 * StateManager.M);
        stage.addActor(scrollpane2);

    }

    // FIXME: 2016-04-03 Point to diary post.
    public void addPost(final MDiaryPost diaryPost){
        Stack s = new Stack();

        Table t = new Table();

        String title = diaryPost.getTitle();

        Label single = new Label(title, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).expand().left().padLeft(10 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        final ExecuteToTempState e = new ExecuteToTempState(new Diary4(this, diaryPost));
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();
    }

    //TODO FIXME: 2016-04-03 Uncomment.
    public void follow(final ArtistProfile profile){
        final ImageButton artistButton = new ImageButton(profile.getImage().getDrawable());
        artistButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteToTempState(profile).execute();
            }
        });

        final ImageButton removeButton = new ImageButton(new Image(new Texture("Other/Unfollow@1.0.png")).getDrawable());
        artistButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                artistButton.remove();
                removeButton.remove();
            }
        });

        following.add(removeButton).width(56 * StateManager.M).height(56 * StateManager.M).padRight(50 * StateManager.M);
        following.add(artistButton).width(150 * StateManager.M).height(150 * StateManager.M).padRight(50 * StateManager.M);
    }


    @Override
    public void dispose() {

    }



//    private void pullData(){
//        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
//        User user = localDatabase.getModel(localDatabase.getUserKeyByName(name));
//
//        updateArtistsFromServer(user);
//        updateDiariesFromServer(user);
//    }
//
//    private void updateArtistsFromServer(User user){
//        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
//        java.util.List<Long> bandKeys = user.getBandKeys();
//
//        for(long key: bandKeys){
//            if(!currentArtists.contains(key)){
//                MBand artist = localDatabase.getModel(key);
//
//                MImage image = localDatabase.getModel(artist.getBandImage());
//
//                Image artistImage = ImageManagerFactory.createImageManager().mImageToImage(image);
//
//                addFollowing(artistImage);
//
//                currentArtists.add(key);
//            }
//        }
//    }
//
//
//    private void updateDiariesFromServer(User user){
//        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
//        UserDiaryContent diaryContent = localDatabase.getModel(user.getDiary());
//
//        boolean isUpdated = true;
//
//        for(long key: diaryContent.getDiaryKeys()){
//            if(!currentDiaries.contains(key)) {
//                if(localDatabase.getModel(key) == null){
//                    localDatabase.requestModelFromServer(key);
//                    isUpdated = false;
//                }
//                MDiaryPost post = localDatabase.getModel(key);
//                if(localDatabase.getModel(post.getText())== null){
//                    localDatabase.requestModelFromServer(post.getText());
//                    isUpdated = false;
//                }
//
//                if(!isUpdated)
//                    continue;
//                UserProfile profile = localDatabase.getModel(user.getProfile());
//
//                String username = profile.getUsername();
//
//                addPost(post, post.getTitle());
//
//                currentDiaries.add(key);
//            }
//        }
//    }
}
