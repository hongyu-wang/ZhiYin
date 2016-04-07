package client.pages.friends.boxes;

import client.pages.other.MyProfile;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import server.model.media.MAudio;

import java.util.ArrayList;
import java.util.List;

import static client.tools.Constants.M;


/**
 * Contains a stack of actors. Used in Friends4.
 */
public class MessageBox implements Disposable{
    //private static float y = 1334; // -56 each time

    private Stack stack;
    private Table table;
    private int byUser;
    private MAudio workingMAudio;

    private String friendName;
    private String timestamp;
    private List<Disposable> disposables;
    private Texture tx;

    private MessageBox(){
        disposables = new ArrayList<>();
    }

    /**
     *
     * @param message The message in the box.
     * @param byUser 0 means not by user, 1 means is by user.
     */
    public MessageBox(String message, int byUser, String friendName, String timestamp){
        this();
        this.friendName = friendName;
        this.timestamp = timestamp;
        initTable(byUser);
        initTextBox(message, timestamp);
    }

    /**
     *
     * @param e The executable associated with the button.
     * @param byUser See above.
     */

    public MessageBox(Executable e, int byUser, MAudio audio, String friendName, String timestamp){
        this();
        this.friendName = friendName;
        this.timestamp = timestamp;
        this.workingMAudio = audio;
        initTable(byUser);
        initSoundBox(e, timestamp);
    }

    private void initTable(int byUser){
        this.byUser = byUser;
        this.stack = new Stack();
        this.table = new Table();

        stack.setWidth(480*M);

        table.layout();
    }

    private void initTextBox(String message, String timestamp){
        Table table1 = new Table();
        Image image = new Image(tx = new Texture("Friends/Bubble" + byUser + "@1.0.png"));
        disposables.add(tx);
        Table table2 = new Table();
        LabelTextArea text = new LabelTextArea(message, SkinSingleton.getInstance());
        text.setPrefRows(message.length()/28 + 1);
        text.pack();
        text.setWidth(460*M);

        float height = (text.getHeight() + 40)*M;

        table1.add(image).width(480*M).height(height);
        table2.add(text).width(460*M).height(height).expand().center().left().padLeft(10*M).padTop(30*M);

        stack.add(table1);
        stack.add(table2);

        stack.setHeight(height);

        stack.layout();
    }

    private void initSoundBox(final Executable e, String timestamp){
        stack.setHeight(128 * M);

        Image image = new Image(tx = new Texture("Friends/Bubble" + byUser + "@1.0.png"));
        disposables.add(tx);
        Table t1 = new Table();
        t1.add(image).width(480*M).height(128*M);
        stack.add(t1);

        Table t2 = new Table();
        t2.setSize(480 * M, 128 * M);

        Image image2 = new Image(tx = new Texture("Friends/Play" + byUser + "@1.0.png"));
        disposables.add(tx);
        final ImageButton button = new ImageButton(image2.getDrawable());
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });
        button.setScale(M);
        t2.add(button).width(68*M).height(68*M).expand().left().padLeft(35*M);

        Image image3 = new Image(tx = new Texture("Friends/Ripples" + byUser + "@1.0.png"));
        disposables.add(tx);
        t2.add(image3).width(362*M).height(88*M).expand().center().right().padRight(25*M);

        stack.add(t2);
    }

    public Table getTable(){
        Label name = new Label(byUser == 1 ? MyProfile.name : friendName, SkinSingleton.getInstance());
        name.setColor(0.5f, 0.5f, 0.5f, 1);
        table.add(name).expandX().left();
        table.row();

        Label time = new Label(timestamp, SkinSingleton.getInstance());
        time.setColor(0.5f, 0.5f, 0.5f, 1);
        table.add(time).expandX().left();
        table.row();

        table.add(stack);

        return table;
    }

    public int getByUser(){
        return this.byUser;
    }

    @Override
    public void dispose() {
        for (Disposable i : disposables){
            i.dispose();
        }
    }
}
