package client.pages.home;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.ArtistProfile;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import server.model.media.MImage;
import server.model.soundCloud.MBand;
import server.services.factories.ImageManagerFactory;
import tools.serverTools.databases.LocalDatabase;
import tools.serverTools.databases.LocalDatabaseFactory;

/**
 * This is the third home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Artist extends ArtistShell implements Gesturable{
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
        table.setBounds(0, 117*M, 750*M, 1000*M);
        table.top();

        scrollpane = new ScrollPane(table);
        scrollpane.setBounds(0, 117*M, 750*M, 1000*M);
        scrollpane.setScrollingDisabled(true, false);

        stage.addActor(scrollpane);

        pullData();
    }

    public void addArtist(MBand band){
        Stack right = new Stack();

        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();

        MImage profileImage = localDatabase.getModel(band.getBandImage());

        Image profilePic = ImageManagerFactory.createImageManager().mImageToImage(profileImage);

        String artistName = band.getName();

        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, band, profilePic), TransitionType.RIGHT_TO_LEFT);
        right.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        Table t1 = new Table();
        t1.add(new Image(tx = new Texture("Home/BlackBG@1.0.png"))).width(600*M).height(150*M);
        disposables.add(tx);
        right.add(t1);

        Table t2 = new Table();
        t2.add(new Label(artistName, SkinSingleton.getInstance())).expand().center().left().padLeft(50*M);
        t2.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26*M).expand().center().right().padRight(50*M);
        disposables.add(tx);
        right.add(t2);

        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(profilePic).width(100*M).height(100 *M).expand().center().padLeft(50*M);
        artistTable.add(right).width(600*M).height(150*M);

        table.add(artistTable).width(750*M).height(150*M);
        table.row();
        table.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50*M);
        disposables.add(tx);
        table.row();
    }

    @Override
    public void reset() {
        super.reset();
        searchField.remove();
        addSearchField();
    }

    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition(26*M, 1146*M);
        searchField.setSize(642*M, 58*M);

        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }

    private void pullData(){
        pullArtistsFromServer();
    }

    private void pullArtistsFromServer(){
        LocalDatabase localDatabase = LocalDatabaseFactory.createLocalDatabase();
        MBand mb;

        for(long i = 12000; i < 12006; i++){
            mb = localDatabase.getModel(i);
            addArtist(mb);
        }
    }

    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.HOME, TransitionType.LEFT_TO_RIGHT).execute();
        else if(!gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.DISCOVERY, TransitionType.RIGHT_TO_LEFT).execute();
    }
}
