package client.pages.musicDiary;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.pageInternal.modelStorage.LocalDatabase;
import client.pages.pageInternal.modelStorage.LocalDatabaseFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.social.MDiaryPost;
import server.model.user.User;
import server.model.user.UserDiaryContent;
import server.model.user.UserProfile;
import tools.utilities.Utils;

import java.util.List;

/**
 * This is the first music diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Diary1 extends Diary1Shell {

    private List<Long> currentDiaries;

    private ScrollPane scrollpane;

    private Table table;

    public Diary1(){
        init();
    }

    protected void init() {
        super.init();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100* StateManager.M);
        table.top();

        currentDiaries = Utils.newList();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);

        stage.addActor(scrollpane);
    }

    public void addPost(MDiaryPost thisPost, String creator){
        String title = thisPost.getTitle();

        String name = creator;

        String timestamp = String.valueOf(thisPost.getTimeStamp());

        Stack s = new Stack();

        Table t = new Table();

        Label l1 = new Label(name, SkinSingleton.getInstance());
        Label l2 = new Label(title, SkinSingleton.getInstance());
        Label l3 = new Label(timestamp, SkinSingleton.getInstance());

        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(l1).expand().left().padLeft(50 * StateManager.M);
        t.add(l2).expand().right().padRight(50 * StateManager.M);
        t.row().padTop(10 * StateManager.M);
        t.add(l3).expand().left().padLeft(50 * StateManager.M);
        t.row();
        t.add(line).padTop(40 * StateManager.M);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        final MDiaryPost currentPost = thisPost;

        // Goes to a Diary4 without content or image
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                new ExecuteToTempState(new Diary4(currentPost)).execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();
    }


    @Override
    public void reset() {

    }



    @Override
    public void dispose() {

    }

    @Override
    public void update(float dt){
        super.update(dt);

        getPostsFromServer();
    }

    private void getPostsFromServer(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createModelStorage();
        User user1 = localDatabase.getModel(1);
        User user2 = localDatabase.getModel(2);
        User user3 = localDatabase.getModel(3);

        updateFromServer(user1);
        updateFromServer(user2);
        updateFromServer(user3);
    }

    private void updateFromServer(User user){
        LocalDatabase localDatabase = LocalDatabaseFactory.createModelStorage();
        UserDiaryContent diaryContent = localDatabase.getModel(user.getDiary());

        boolean isUpdated = true;

        for(long key: diaryContent.getDiaryKeys()){
            if(!currentDiaries.contains(key)) {
                if(localDatabase.getModel(key) == null){
                    localDatabase.requestModelFromServer(key);
                    isUpdated = false;
                }
                MDiaryPost post = localDatabase.getModel(key);
                if(localDatabase.getModel(post.getText())== null){
                    localDatabase.requestModelFromServer(post.getText());
                    isUpdated = false;
                }

                if(!isUpdated)
                    continue;
                UserProfile profile = localDatabase.getModel(user.getProfile());

                String username = profile.getUsername();

                addPost(post, username);

                currentDiaries.add(key);
            }
        }
    }
}
