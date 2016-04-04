package client.pages.home;


import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateTags;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * This is the fourth home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Discovery extends DiscoveryShell {
    private Table table;

    private int numTags;

    private TextField searchField;

    private ExecuteUpdate update;

    public Discovery(){
        init();
    }

    protected void init() {
        super.init();

        addSearchField();

        Table t = new Table();
        t.setBounds(0, 0, 750 * StateManager.M, 1134 * StateManager.M);
        t.add(table);
        stage.addActor(t);

        table = new Table();
//        table.setBounds(0, 0, 750 * StateManager.M, 1134 * StateManager.M);
        table.top();
        table.setFillParent(true);

        numTags = 0;

        this.update = new ExecuteUpdateTags(this);
    }

    public void addTag(String tagName){
//        Label tag = new Label(tag, SkinSingleton.getInstance());
        TextButton tag = new TextButton(tagName, SkinSingleton.getInstance());
        final ExecuteToTempState e = new ExecuteToTempState(new Tagged(this, tagName));
        tag.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        addWrapped(tag);

        //table.layout();
        table.setDebug(true);
    }

    private void addWrapped(Actor actor){
        float initWidth = table.getWidth();
        Cell cell = table.add(actor).padLeft(20 * StateManager.M).padRight(20 * StateManager.M);

        System.out.println("initWidth: " + initWidth);

        if(table.getWidth() > initWidth){
            System.out.println("width: " + table.getWidth());
            table.removeActor(actor);
            table.row();
            table.add(actor).padLeft(20 * StateManager.M).padRight(20 * StateManager.M);
        }
    }

    @Override
    public void reset() {
        super.reset();
        searchField.remove();
        addSearchField();
    }



    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition((26 + 1) * M, 1146 * M);
        searchField.setSize((750 - 26*2) * M, 58 * M);
        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }

    @Override
    public void dispose() {

    }

}
