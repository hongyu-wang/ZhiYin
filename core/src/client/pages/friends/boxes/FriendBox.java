package client.pages.friends.boxes;

import client.events.executables.internalChanges.serverInteractions.ExecuteSeenBy;
import client.events.executables.internalChanges.serverInteractions.ExecuteSeenByMe;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.friends.Friends2;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static client.tools.Constants.M;

/**
 * Contains a table of actors. Used in Friends1.
 */
public class FriendBox{
    private Table table;
    private Image currentIcon;
    private String friendName;
    private int state = 0;

    private ExecuteUpdate update;
    /**
     *
     * @param iconNum The number representing an icon.
     * @param friendName The friend's name.
     */
    public FriendBox(int iconNum, String friendName){
        this.friendName = friendName;
        setIcon(iconNum);

        this.update = new ExecuteSeenBy(this, friendName);
    }

    private void setTable(){
        Stack right = new Stack();

        right.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteToTempState(new Friends2(friendName)).execute();
                new ExecuteSeenByMe(friendName, update).execute();
            }
        });

        Table t1 = new Table();
        t1.add(new Image(new Texture("Home/BlackBG@1.0.png"))).width(650*M).height(110*M);
        right.add(t1);

        Table t2 = new Table();
        t2.add(new Label(friendName, SkinSingleton.getInstance())).expand().center().left().padLeft(50*M);
        t2.add(new Image(new Texture("Home/Enter@1.0.png"))).width(16*M).height(26*M).expand().center().right().padRight(50*M);
        right.add(t2);

        Table artistTable = new Table();
        artistTable.top();
        artistTable.add(currentIcon).width(28 *M).height(36*M).expand().center().padLeft(50*M);
        artistTable.add(right).width(650*M).height(110*M);

        table = new Table();
        table.add(artistTable).width(750*M).height(110*M);
        table.row();
        table.add(new Image(new Texture("Home/Line@1.0.png"))).width(750*M).height(4*M).expandX().padLeft(50*M);
        table.row();

        //table.setDebug(true);
    }

    public Table getTable(){
        return table;
    }

    public void setIcon(int iconNum){
        Image image = new Image(new Texture("Friends/Icon" + iconNum + "@1.0.png"));
        currentIcon = image;
        setTable();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
