package client.pages.friends.boxes;

import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.friends.Friends2;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Contains a table of actors. Used in Friends1.
 */
public class FriendBox{

    public static final int RECIEVED_READ = 1;
    public static final int RECIEVED_UNREAD = 2;
    public static final int SENT_READ = 3;
    public static final int SENT_UNREAD = 4;

    private Table table;
    private Image currentIcon;
    private String friendName;
    /**
     *
     * @param iconNum The number representing an icon.
     * @param friendName The friend's name.
     */
    public FriendBox(int iconNum, String friendName){
        initTable();
        this.friendName = friendName;
        addIcon(iconNum);
        addLabel(friendName);
        addButton();
    }

    private void initTable(){
        this.table = new Table();
//        table.setBounds(0, y * StateManager.M, 750 * StateManager.M, 117 * StateManager.M);
    }

    private void addIcon(int iconNum){
        setIcon(iconNum);
    }

    private void addLabel(String friendName){
        Label name = new Label(friendName, SkinSingleton.getInstance());
        table.add(name).padLeft(20 * StateManager.M);
    }

    private void addButton(){
        Image i = new Image(new Texture("Friends/Enter@" + StateManager.M + ".png"));
        final ImageButton button = new ImageButton(i.getDrawable());

        table.add(button).expandX().right().padRight(20 * StateManager.M);
    }

    public Stack getStack(){
        Stack s = new Stack();

        Image i = new Image(new Texture("Home/BlackBG@" + StateManager.M + ".png"));

        s.add(i);
        s.add(table);

        final Friends2 f2 = new Friends2(friendName);

        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteToTempState(f2).execute();
            }
        });

        return s;
    }

    public void setIcon(int iconNum){
        table.removeActor(currentIcon);

        Texture texture = new Texture("Friends/Icon" + iconNum + "@" + StateManager.M +".png");
        Image image = new Image(texture);
        this.currentIcon = image;

        table.add(currentIcon).padLeft(60 * StateManager.M);
    }
}
