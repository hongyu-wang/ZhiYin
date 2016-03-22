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


/**
 * Contains a table of actors. Used in Friends4.
 */
public class MessageBox {

    private static float y = 1334 - 56; // -56 each time

    private Stack stack;
    private int byUser;

    /**
     *
     * @param message The message in the box.
     * @param byUser 0 means not by user, 1 means is by user.
     */
    public MessageBox(String message, int byUser){
        initTable(byUser);
        initTextBox(message);
    }

    /**
     *
     * @param e The executable associated with the button.
     * @param byUser See above.
     */
    public MessageBox(Executable e, int byUser){
        initTable(byUser);
        initSoundBox(e);
    }

    private void initTable(int byUser){
        this.byUser = byUser;
        this.stack = new Stack();
        //stack.setBounds((32 + 214 * byUser) * StateManager.M, y * StateManager.M, 480 * StateManager.M, 128 * StateManager.M);

        stack.setWidth(480 * StateManager.M);
        stack.setX((32 + 214 * byUser) * StateManager.M);
        //stack.setPosition((32 + 214 * byUser) * StateManager.M, 400 * StateManager.M);
        //System.out.println("stack height: " + stack.getHeight());
    }

    private void initTextBox(String message){
//        Image image = new Image(new Texture("Friends4\\Bubble" + byUser + "@" + StateManager.M + ".png"));
//        stack.add(image);
//
//        Table table = new Table();
//        Label text = new Label(message, SkinSingleton.getInstance());
//        text.setWrap(true);
//        table.add(text).expand().center().padLeft(20 * StateManager.M).width(480 * StateManager.M);
//
//        stack.add(table);

        Table table1 = new Table();
        Image image = new Image(new Texture("Friends4\\Bubble" + byUser + "@" + StateManager.M + ".png"));

        Table table2 = new Table();
        Label text = new Label(message, SkinSingleton.getInstance());
        text.setWrap(true);

        text.setWidth(240 * StateManager.M);
        text.pack();
        float height = text.getHeight();
        //System.out.println("text height: " + height);

        table1.add(image).width(480 * StateManager.M).height(height * StateManager.M);
        table2.add(text).expand().center().padLeft(20 * StateManager.M).width(480 * StateManager.M);

        stack.add(table1);
        stack.add(table2);

        stack.setY((y - height) * StateManager.M);
        //System.out.println("stack y: " + stack.getY());

        y = y - height - 56;
        //System.out.println("y: " + y);
    }

    private void initSoundBox(Executable e){
        Image image = new Image(new Texture("Friends4\\Bubble" + byUser + "@" + StateManager.M + ".png"));
        stack.add(image);

        Table table = new Table();

        Image image2 = new Image(new Texture("Friends4\\Play" + byUser + "@" + StateManager.M + ".png"));
        final ImageButton button = new ImageButton(image2.getDrawable());
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });
        table.add(button).expand().left().padLeft(35 * StateManager.M);

        Image image3 = new Image(new Texture("Friends4\\Ripples" + byUser + "@" + StateManager.M + ".png"));
        table.add(image3).expand().right().padRight(25 * StateManager.M);

        stack.add(table);
    }

    public Stack getStack(){
        return this.stack;
    }

}
