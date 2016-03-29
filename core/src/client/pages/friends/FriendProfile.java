package client.pages.friends;

import client.component.basicComponents.Button;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.State;
import client.pages.musicDiary.Diary4;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.media.MText;
import server.model.social.MDiaryPost;
import server.model.soundCloud.MBand;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.model.user.UserProfile;
import java.util.List;

import server.services.factories.ImageManagerFactory;
import tools.utilities.Utils;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class FriendProfile extends FriendProfileShell {
    private List<Long> currentDiaries;
    private List<Long> currentArtists;

    private State previousState;

    private ScrollPane scrollpane;
    private ScrollPane scrollpane2;

    private Table table;
    private Table following;

    private String name;

    private Image image;

    public FriendProfile(State previousState, String name){
        this.previousState = previousState;
        this.name = name;

        currentDiaries = Utils.newList();
        currentArtists = Utils.newList();
        init();
    }

    public FriendProfile(State previousState, String name, Image image){
        this.previousState = previousState;
        this.name = name;
        this.image = image;
        init();
    }

    protected void init(){
        super.init();

        Button backButton = new Button(this);
        backButton.setBounds(0, 1217, 117, 117);
        backButton.setExecutable(new ExecuteToTempState(previousState));
        add(backButton);

        Label label = new Label(name, SkinSingleton.getInstance());
        label.setPosition(310 * StateManager.M, 1050 * StateManager.M);
        stage.addActor(label);

        if(image != null) {
            image.setBounds(50 * StateManager.M, 967 * StateManager.M, 200 * StateManager.M, 200 * StateManager.M);
            stage.addActor(image);
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



        addFollowing(new Image(new Texture("Artist/Artist1.png")));
        addFollowing(new Image(new Texture("Artist/Artist2.png")));
        addFollowing(new Image(new Texture("Artist/Artist3.png")));
        addFollowing(new Image(new Texture("Artist/Artist4.png")));
        addFollowing(new Image(new Texture("Artist/Artist5.png")));

    }

    private void addPost(MDiaryPost thisPost, String post){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(post, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(single).padLeft(10 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        final Executable e = new ExecuteToTempState(new Diary4(thisPost));

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();
    }

    private void addFollowing(Image image){
        following.add(image).width(150 * StateManager.M).height(150 * StateManager.M).padRight(50 * StateManager.M);
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt) {
        super.update(dt);

        pullData();
    }

    private void pullData(){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        User user = ms.getModel(ms.getUserKeyByName(name));

        updateArtistsFromServer(user);
        updateDiariesFromServer(user);
    }

    private void updateArtistsFromServer(User user){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        List<Long> bandKeys = user.getBandKeys();

        for(long key: bandKeys){
            if(!currentArtists.contains(key)){
                MBand artist = ms.getModel(key);

                MImage image = ms.getModel(artist.getBandImage());

                Image artistImage = ImageManagerFactory.createImageManager().mImageToImage(image);

                addFollowing(artistImage);

                currentArtists.add(key);
            }
        }
    }


    private void updateDiariesFromServer(User user){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        UserDiaryContent diaryContent = ms.getModel(user.getDiary());

        boolean isUpdated = true;

        for(long key: diaryContent.getDiaryKeys()){
            if(!currentDiaries.contains(key)) {
                if(ms.getModel(key) == null){
                    ms.requestModelFromServer(key);
                    isUpdated = false;
                }
                MDiaryPost post = ms.getModel(key);
                if(ms.getModel(post.getText())== null){
                    ms.requestModelFromServer(post.getText());
                    isUpdated = false;
                }

                if(!isUpdated)
                    continue;
                UserProfile profile = ms.getModel(user.getProfile());

                String username = profile.getUsername();

                addPost(post, post.getTitle());

                currentDiaries.add(key);
            }
        }
    }
}