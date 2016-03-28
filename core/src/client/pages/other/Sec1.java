package client.pages.other;

import client.component.basicComponents.Button;
import client.component.basicComponents.DragButton;
import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddDragButton;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteAddImage;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteRemoveDragButton;
import client.events.executables.internalChanges.dragButtonExecutables.ExecuteRemoveImage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pages.State;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import static client.singletons.StateManager.M;

/**
 * Created by blobbydude24 on 2016-03-28.
 */
public class Sec1 extends Sec1Shell {

    private ImageButton holdToRecordButton;

    private State previousState;

    private ScrollPane scrollpane;
    private Table posts;

    private String title;
    private String subtitle;

    //private DragButton dragButton;

    public Sec1(State previousState, String title, String subtitle){
        this.previousState = previousState;
        this.title = title;
        this.subtitle = subtitle;
        init();
    }

    protected void init(){
        super.init();

        ExecuteToTempState backEx = new ExecuteToTempState(previousState);
        addImageButton("NowPlaying/Back@", backEx, 0, 1217, 117, 117);

        Image image = new Image(new Texture("Friends/SwipeToDiscardButton@" + StateManager.M + ".png"));
        image.setBounds(26 * M, 130 * M, 698 * M, 236 * M);
        Image label = new Image(new Texture("Other/HoldToRecord@" + StateManager.M + ".png"));
        label.setPosition(260 * M, 65 * M);

        DragButton dragButton = new DragButton(this, (int)(400 * StateManager.M));
        dragButton.setBounds(0, 0, 0, 0);
        ExecutableMultiplexer em = new ExecutableMultiplexer();
        em.addExecutable(new ExecuteRemoveDragButton(dragButton));
        em.addExecutable(new ExecuteRemoveImage(image));
        em.addExecutable(new ExecuteAddImage(stage, label));
        dragButton.setDragExecutable(em);

        ExecutableMultiplexer em2 = new ExecutableMultiplexer();
        em2.addExecutable(new ExecuteRemoveDragButton(dragButton));
        em2.addExecutable(new ExecuteRemoveImage(image));
        em2.addExecutable(new ExecuteAddImage(stage, label));
        em2.addExecutable(new ExecuteToTempState(new Sec2(this, previousState)));
        dragButton.setReleaseExecutable(em2);
        add(dragButton);

        Button holdToRecordButton = new Button(this);
        holdToRecordButton.setBounds(26, 57, 698, 58);
        ExecutableMultiplexer recordEx = new ExecutableMultiplexer();
        recordEx.addExecutable(new ExecuteAddDragButton(dragButton, 26, 130, 698, 236));
        recordEx.addExecutable(new ExecuteAddImage(stage, image));
        recordEx.addExecutable(new ExecuteRemoveImage(label));
        holdToRecordButton.setExecutable(recordEx);

        stage.addActor(label);
        add(holdToRecordButton);

        initTable();

        posts = new Table();
        posts.top();

        scrollpane = new ScrollPane(posts);
        scrollpane.setBounds(0, 200 * StateManager.M, 750 * StateManager.M, 800 * StateManager.M);
        stage.addActor(scrollpane);

        addPost("name", "time");
        addPost("name", "time");
        addPost("name", "time");
        addPost("name", "time");
    }

    private void initTable(){
        Label label1 = new Label(title, SkinSingleton.getInstance());
        Label label2 = new Label(subtitle, SkinSingleton.getInstance());

        Table table = new Table();
        table.setBounds(0, 1000 * StateManager.M, 750 * StateManager.M, 217 * StateManager.M);
        table.add(label1).expand();
        table.row();
        table.add(label2).expand();
        stage.addActor(table);
    }

    public void addPost(String name, String time){
        Table t = new Table();
        Label label1 = new Label(name + "\n" + time, SkinSingleton.getInstance());
        Image ripples = new Image(new Texture("Friends4\\Ripples0@" + StateManager.M + ".png"));
        Image play = new Image(new Texture("Friends4\\Play0@" + StateManager.M + ".png"));
        Image line = new Image(new Texture("Home/Line@" + StateManager.M + ".png"));

        t.add(label1).expand().left().padLeft(50 * StateManager.M).padTop(50 * StateManager.M);
        t.add(ripples).width(328 * StateManager.M).height(66 * StateManager.M).padTop(50 * StateManager.M);
        t.add(play).width(68 * StateManager.M).height(68 * StateManager.M).padTop(50 * StateManager.M);;
        t.row();
        t.add(line).width(750 * StateManager.M).padLeft(100 * StateManager.M).padTop(50 * StateManager.M);

        posts.add(t).width(750 * StateManager.M).height(140 * StateManager.M);
        posts.row();
    }

    @Override
    public void reset() {

    }

    @Override
    public void dispose() {

    }
}
