package client.pages.home;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.other.ArtistProfile;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Tagged extends TaggedShell {

    private String tag;

    private ScrollPane scrollpane;

    private Table table;

    private Image image;

    private State previousState;

    public Tagged(State previousState, String tag){
        this.previousState = previousState;
        this.tag = tag;
        init();
    }

    protected void init(){
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Label tagName = new Label(tag, SkinSingleton.getInstance());
        tagName.setPosition(250, 1217);
        stage.addActor(tagName);

        Table tagTable = new Table();
        tagTable.setBounds(117 * StateManager.M, 1217 * StateManager.M, 633 * StateManager.M, 117 * StateManager.M);
        stage.addActor(tagTable);

        Label tagLabel = new Label(tag, SkinSingleton.getInstance());
        tagTable.add(tagLabel).expand();

        table = new Table();
        table.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100* StateManager.M);
        table.top();

        scrollpane = new ScrollPane(table);

        scrollpane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);

        stage.addActor(scrollpane);

        //scrollpane.layout();

        addArtist("Artist/Artist1.png", "Artist1");
        addArtist("Artist/Artist2.png", "Artist2");
        addArtist("Artist/Artist3.png", "Artist3");
        addArtist("Artist/Artist4.png", "Artist4");
        addArtist("Artist/Artist5.png", "Artist5");
    }

    public void addArtist(String picturePath, String artistName){
        Stack s = new Stack();

        Table t = new Table();

        Label single = new Label(artistName, SkinSingleton.getInstance());
        Image i = new Image(new Texture("Home/Enter@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));
        Image picture = new Image(new Texture(picturePath));

        //t.add(picture).expand().left().padLeft(50 * StateManager.M);
        t.add(single).expand().left().padLeft(50 * StateManager.M).padTop(50 * StateManager.M);
        t.add(i).expand().right().padRight(50 * StateManager.M);
        t.row();
        t.add(line).width(750 * StateManager.M).padLeft(100 * StateManager.M).padTop(50 * StateManager.M);

        Image i2 = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i2);
        s.add(t);

        //TODO fix this
        final ExecuteToTempState e = new ExecuteToTempState(new ArtistProfile(this, picture, artistName));

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        table.add(s).width(750 * StateManager.M).height(110 * StateManager.M);
        table.row();

        //scrollpane.layout();
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
