package client.pages.friends.boxes;

import client.events.executables.internalChanges.ExecuteChangePage;
import client.pageStorage.Pages;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class FriendBox{

    private Table table;
    private Image currentIcon;

    /**
     *
     * @param y The vertical distance from the top bar.
     * @param iconNum The number representing an icon.
     * @param friendName The friend's name.
     */
    public FriendBox(int y, int iconNum, String friendName){
        initTable(y);

        initIcon(iconNum);
        initLabel(friendName);
        initButton();
    }

    private void initTable(int y){
        this.table = new Table();
        table.setBounds(0, (1100 - y) * StateManager.M, 750 * StateManager.M, 117 * StateManager.M);
    }

    private void initIcon(int iconNum){
        setIcon(iconNum);
    }

    private void initLabel(String friendName){
        Label name = new Label(friendName, SkinSingleton.getInstance());
        table.add(name).padLeft(20 * StateManager.M);
    }

    private void initButton(){
        Image i = new Image(new Texture("Chevron" + StateManager.M + ".png"));
        final ImageButton button = new ImageButton(i.getDrawable());

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                new ExecuteChangePage(Pages.FRIENDS4).execute();
            }
        });

        table.add(button).expandX().right().padRight(20 * StateManager.M);
    }

    public Table getTable(){
        return this.table;
    }

    public void setIcon(int iconNum){
        table.removeActor(currentIcon);

        Texture texture = new Texture("Friends1\\Icon" + iconNum + "@" + StateManager.M +".png");
        Image image = new Image(texture);
        this.currentIcon = image;

        table.add(currentIcon).padLeft(60 * StateManager.M);
    }
}
