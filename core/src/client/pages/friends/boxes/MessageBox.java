package client.pages.friends.boxes;

import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import server.model.media.MAudio;


/**
 * Contains a stack of actors. Used in Friends4.
 */
public class MessageBox {
    //private static float y = 1334; // -56 each time

    private Stack stack;
    private Table table;
    private int byUser;
    private MAudio workingMAudio;
    private String timestamp;


    /**
     *
     * @param message The message in the box.
     * @param byUser 0 means not by user, 1 means is by user.
     */
    public MessageBox(String message, int byUser, String timestamp){
        this.timestamp = timestamp;
        initTable(byUser);
        initTextBox(message, timestamp);
    }

    /**
     *
     * @param e The executable associated with the button.
     * @param byUser See above.
     */
    public MessageBox(Executable e, int byUser, MAudio audio, String timestamp){
        this.timestamp = timestamp;
        this.workingMAudio = audio;
        initTable(byUser);
        initSoundBox(e, timestamp);
    }

    private void initTable(int byUser){
        this.byUser = byUser;
        this.stack = new Stack();
        this.table = new Table();

        //stack.setX((32 + 214 * byUser) * StateManager.M);
        stack.setWidth(480 * StateManager.M);

        table.layout();
    }

    private void initTextBox(String message, String timestamp){
        Table table1 = new Table();
        Image image = new Image(new Texture("Friends4/Bubble" + byUser + "@" + StateManager.M + ".png"));

        Table table2 = new Table();
        Label text = new Label(message, SkinSingleton.getInstance());
        text.setWrap(true);

        text.setWidth(230 * StateManager.M);
        text.pack();
        float height = text.getHeight() + 40;

        table1.add(image).width(480 * StateManager.M).height(height * StateManager.M);
        table2.add(text).expand().center().left().padLeft(10*StateManager.M).width(460 * StateManager.M);

        stack.add(table1);
        stack.add(table2);

        stack.setHeight(height * StateManager.M);

        stack.layout();
    }

    private void initSoundBox(final Executable e, String timestamp){
        stack.setHeight(128 * StateManager.M);

        Image image = new Image(new Texture("Friends4/Bubble" + byUser + "@" + StateManager.M + ".png"));
        stack.add(image);

        Table table = new Table();

        Image image2 = new Image(new Texture("Friends4/Play" + byUser + "@" + StateManager.M + ".png"));
        final ImageButton button = new ImageButton(image2.getDrawable());
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });
        table.add(button).expand().left().padLeft(35 * StateManager.M);

        Image image3 = new Image(new Texture("Friends4/Ripples" + byUser + "@" + StateManager.M + ".png"));
        table.add(image3).expand().right().padRight(25 * StateManager.M);

        stack.add(table);

        stack.layout();
    }

    public Table getTable(){
        Label label = new Label(timestamp, SkinSingleton.getInstance());
        label.setColor(0.5f, 0.5f, 0.5f, 1);
        table.add(label).expandX().left();
        table.row();
        table.add(stack);
        return table;
    }

    public int getByUser(){
        return this.byUser;
    }

}
