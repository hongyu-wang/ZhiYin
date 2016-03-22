package client.pages.friends.boxes;

import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by blobbydude24 on 2016-03-21.
 */
public class MessageBox {

    private Table table;

    /**
     *
     * @param message The message in the box.
     * @param y The box's vertical distance form the bottom.
     * @param byUser 0 means not by user, 1 means is by user.
     */
    public MessageBox(String message, int y, int byUser){
        initTable(y, byUser);
        initTextBox(message);
    }

    /**
     *
     * @param e The executable associated with the button.
     * @param y See above.
     * @param byUser See above.
     */
    public MessageBox(Executable e, ActionMonitor monitor, int y, int byUser){
        initTable(y, byUser);
        initSoundBox(e, monitor);
    }

    private void initTable(int y, int byUser){
        this.table = new Table();
        table.setBounds((32 + 214 * byUser) * StateManager.M, y * StateManager.M, 480 * StateManager.M, 128 * StateManager.M);
    }

    private void initTextBox(String message){
        Label text = new Label(message, SkinSingleton.getInstance());
        table.add(text).expand();
    }

    private void initSoundBox(Executable e, ActionMonitor monitor){
//        Image i = new Image(new Texture("Chevron" + StateManager.M + ".png"));
//        final ImageButton button = new ImageButton(i.getDrawable());
//
//        button.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                new ExecuteChangePage(Pages.FRIENDS4).execute();
//            }
//        });
//
//        table.add(button).expandX().right().padRight(20 * StateManager.M);

    }

    public Table getTable(){
        return this.table;
    }

}
