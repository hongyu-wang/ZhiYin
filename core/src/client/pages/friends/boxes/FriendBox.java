package client.pages.friends.boxes;

import client.events.executables.internalChanges.serverInteractions.ExecuteSeenBy;
import client.events.executables.internalChanges.serverInteractions.ExecuteSeenByMe;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.pages.friends.Friends2;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.List;

import static client.tools.Constants.M;

/**
 * Contains a table of actors. Used in Friends1.
 */
public class FriendBox implements Disposable {
    private State friends1;

    private Table table;
    private Image currentIcon;
    private String friendName;
    private int state = 0;
    private ExecuteUpdate update;
    private Texture tx;
    private List<Disposable> disposables;


    /**
     *
     * @param iconNum The number representing an icon.
     * @param friendName The friend's name.
     */
    public FriendBox(State friends1, int iconNum, String friendName){
        disposables = new ArrayList<>();
        this.friends1 = friends1;
        this.friendName = friendName;
        setIcon(iconNum);

        this.update = new ExecuteSeenBy(this, friendName);
    }

    private void setTable(){
        Stack right = new Stack();

        right.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteToTempState(new Friends2(friends1, friendName), TransitionType.RIGHT_TO_LEFT).execute();
                new ExecuteSeenByMe(friendName, update).execute();
            }
        });

        Table t1 = new Table();
        t1.add(new Image(tx = new Texture("Home/BlackBG@1.0.png"))).width(650*M).height(110 * M);
        disposables.add(tx);
        right.add(t1);

        Table t2 = new Table();
        t2.add(new Label(friendName, SkinSingleton.getInstance())).expand().center().left().padLeft(50*M);
        t2.add(new Image(tx = new Texture("Home/Enter@1.0.png"))).width(16*M).height(26 * M).expand().center().right().padRight(50 * M);
        right.add(t2);
        disposables.add(tx);

        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(currentIcon).width(28 *M).height(36*M).expand().center().padLeft(50 * M);
        artistTable.add(right).width(650 * M).height(110 * M);

        table = new Table();
        table.add(artistTable).width(750*M).height(110*M);
        table.row();
        table.add(new Image(tx = new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50 * M);
        table.row();
        disposables.add(tx);
        //table.setDebug(true);
    }

    public Table getTable(){
        return table;
    }

    public void setIcon(int iconNum){
        Image image = new Image(tx = new Texture("Friends/Icon" + iconNum + "@1.0.png"));
        currentIcon = image;
        setTable();
        disposables.add(tx);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void dispose() {
        for (Disposable disposable : disposables){
            disposable.dispose();
        }
    }
}
