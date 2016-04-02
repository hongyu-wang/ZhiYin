package client.pages.home;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.other.ArtistProfile;
import client.pages.pageInternal.modelStorage.ModelStorage;
import client.pages.pageInternal.modelStorage.ModelStorageFactory;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.soundCloud.MBand;
import server.services.factories.ImageManagerFactory;

import static client.singletons.StateManager.M;

/**
 * This is the third home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Artist extends ArtistShell {
    private TextField searchField;

    private ScrollPane scrollpane;

    private Table table;

    public Artist(){
        init();
    }

    public Artist(Image image){
        init();
    }

    protected void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000* StateManager.M);
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1000 * StateManager.M);
        scrollpane.setScrollingDisabled(true, false);

        stage.addActor(scrollpane);

        pullData();
    }

    public void addArtist(MBand band){
        Stack right = new Stack();

        ModelStorage ms = ModelStorageFactory.createModelStorage();

        MImage profileImage = ms.getModel(/*band.getBandImage()*/ 101L);

        Image profilePic = ImageManagerFactory.createImageManager().mImageToImage(profileImage);

        String artistName = band.getName();

        String description = band.getDescription();

        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, profilePic, artistName, description));
        right.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        Table t1 = new Table();
        t1.add(new Image(new Texture("Home/BlackBG@" + M + ".png"))).width(600 * M).height(150*M);
        right.add(t1);

        Table t2 = new Table();
        t2.add(new Label(artistName, SkinSingleton.getInstance())).expand().center().left().padLeft(50*M);
        t2.add(new Image(new Texture("Home/Enter@" + M + ".png"))).width(16*M).height(26*M).expand().center().right().padRight(50*M);
        right.add(t2);

        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(profilePic).width(100*M).height(100*M).expand().center().padLeft(50*M);
        artistTable.add(right).width(600*M).height(150*M);

        table.add(artistTable).width(750*M).height(150*M);
        table.row();
        table.add(new Image(new Texture("Home/Line@" + M + ".png"))).width(750*M).expandX().padLeft(50*M);
        table.row();
    }

    @Override
    public void reset() {
        searchField.remove();
        addSearchField();
    }

    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition((26 + 1) * M, 1146 * M);
        searchField.setSize(642 * M, 58 * M);

        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something


    }


    @Override
    public void dispose() {

    }

    private void pullData(){
        pullArtistsFromServer();
    }

    private void pullArtistsFromServer(){
        ModelStorage ms = ModelStorageFactory.createModelStorage();
        MBand mb;

        for(long i = 12000; i < 12006; i++){
            mb = ms.getModel(i);
            addArtist(mb);
        }
    }
}
